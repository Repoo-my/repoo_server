package com.repoo.domain.main.user.presentation;

import com.repoo.domain.main.user.presentation.dto.response.UserInfo;
import com.repoo.domain.main.user.service.CommandUsersService;
import com.repoo.domain.main.user.service.QueryUsersService;
import com.repoo.global.jwt.decode.JWTPayloadDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    private final CommandUsersService commandUsersService;
    private final QueryUsersService queryUsersService;
    private final JWTPayloadDecoder jwtPayloadDecoder;

    @GetMapping("/info")
    public UserInfo getUserInfo(
            @RequestHeader Map<String, String> headerData
    ) {
        return queryUsersService.getUserInfo(
                jwtPayloadDecoder.jwtPayloadDecode(headerData.get("access_token"))
        );
    }
}
