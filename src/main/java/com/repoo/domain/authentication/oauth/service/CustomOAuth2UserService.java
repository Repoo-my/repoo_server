package com.repoo.domain.authentication.oauth.service;

import com.repoo.domain.authentication.oauth.exception.SocialUserExistedException;
import com.repoo.domain.authentication.oauth.service.dto.*;
import com.repoo.domain.main.user.domain.Users;
import com.repoo.domain.main.user.domain.repository.UsersRepository;
import com.repoo.domain.main.user.domain.value.Authority;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UsersRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        log.warn("오어스 서비스 registrationId : " + registrationId);

        if (registrationId.equals("google")){
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("naver")){
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("kakao")){
            oAuth2Response = new KakaoResponse(oAuth2User.getAttributes());
        }
        else{
            return null;
        }

        log.warn("오어스 서비스 oAuth2Response : " + oAuth2Response.toString());
        String type = oAuth2Response.getProvider()+" "+oAuth2Response.getProviderId();

        Optional<Users> existData = userRepository.findByUserEmail(oAuth2Response.getEmail());
        Long id;


        if (existData.isEmpty()) {
            Users users = Users.socialUserBuilder()
                    .email(oAuth2Response.getEmail())
                    .role(Authority.USER)
                    .type(type)
                    .build();

            userRepository.save(users);
            id = users.getUsersId();
        } else {

            if (existData.get().getType().equals("normal")) {
                log.warn("이미 존재합니다.");
                throw new SocialUserExistedException();
            }

            existData.get().updateSocial(oAuth2Response.getEmail(), type);
            userRepository.save(existData.get());
            id = existData.get().getUsersId();
        }

        UserDto userDto = UserDto.builder()
                .id(id)
                .role(Authority.USER)
                .oauthType(registrationId)
                .build();
        log.warn("오어스 서비스 userDto : " + userDto.toString());
        return new CustomOAuth2User(userDto);
    }
}
