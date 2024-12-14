package com.repoo.user.presentation;

import com.repoo.user.service.CommandUsersService;
import com.repoo.user.service.QueryUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    private final CommandUsersService commandUsersService;
    private final QueryUsersService queryUsersService;


}
