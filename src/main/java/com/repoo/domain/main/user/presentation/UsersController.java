package com.repoo.domain.main.user.presentation;

import com.repoo.domain.main.user.service.CommandUsersService;
import com.repoo.domain.main.user.service.QueryUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    private final CommandUsersService commandUsersService;
    private final QueryUsersService queryUsersService;

//    @GetMapping("/info")
//    public UserInfo getUserInfo(
//            @RequestBody String accessToken
//    ) {
//
//    }
}
