package com.repoo.domain.main.user.presentation;

import com.repoo.domain.main.user.presentation.dto.response.UserInfo;
import com.repoo.domain.main.user.service.CommandUsersService;
import com.repoo.domain.main.user.service.QueryUsersService;
import com.repoo.global.jwt.decode.JWTPayloadDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    private final CommandUsersService commandUsersService;
    private final QueryUsersService queryUsersService;
    private final JWTPayloadDecoder jwtPayloadDecoder;

    @GetMapping("/info")
    public UserInfo getUserInfo(
            @RequestHeader String accessToken
    ){
        return queryUsersService.getUserInfo(
                jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @GetMapping("/info/email")
    public String getUserEmail(
            @RequestHeader String accessToken
    ){
        log.warn("accessToken: "+ accessToken);
        return queryUsersService.getUserEmail(
                jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @PutMapping
    public void userUpdate(
            @RequestHeader String accessToken,
            @RequestBody UserInfo userInfo
    ){
        commandUsersService.update(accessToken, userInfo);
    }

    @DeleteMapping
    public void userDelete(
            @RequestHeader String accessToken
    ){
        commandUsersService.delete(accessToken);
    }
}
