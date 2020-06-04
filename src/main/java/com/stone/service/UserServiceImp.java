package com.stone.service;

import com.stone.dao.UserRepository;
import com.stone.po.User;
import com.stone.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String name, String password) {
        User user = userRepository.findByUsernameAndPassword(name, MD5Utils.code(password));
        return user;
    }
}
