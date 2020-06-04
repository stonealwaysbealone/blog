package com.stone.service;

import com.stone.po.User;

public interface UserService {
    User checkUser(String name, String password);
}
