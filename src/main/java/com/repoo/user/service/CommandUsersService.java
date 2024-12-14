package com.repoo.user.service;

import com.repoo.user.domain.Users;
import com.repoo.user.service.implementation.UsersCreator;
import com.repoo.user.service.implementation.UsersDeleter;
import com.repoo.user.service.implementation.UsersReader;
import com.repoo.user.service.implementation.UsersUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandUsersService {

    private final UsersCreator usersCreator;
    private final UsersDeleter usersDeleter;
    private final UsersUpdater usersUpdater;
    private final UsersReader usersReader;

    public void save(Users user){
        usersCreator.save(user);
    }

    public void update(Long userId, Users user){
        usersUpdater.update(usersReader.findById(userId), user);
    }

    public void delete(Long userId){
        usersDeleter.delete(userId);
    }
}
