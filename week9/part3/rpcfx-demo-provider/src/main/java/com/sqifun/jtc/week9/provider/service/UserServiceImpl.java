package com.sqifun.jtc.week9.provider.service;

import com.sqifun.jtc.week9.api.User;
import com.sqifun.jtc.week9.api.UserService;

/**
 * @program: week9-part3
 * @className: UserServiceImpl
 * @description:
 * @author: sqi
 * @date: 2022-03-12 13:52
 * @version: 1.0
 **/
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }

}
