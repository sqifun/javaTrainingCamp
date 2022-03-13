package com.sqifun.jtc.week9.consumer;

import com.sqifun.jtc.week9.api.User;
import com.sqifun.jtc.week9.api.UserService;
import com.sqifun.jtc.week9.core.client.Rpcfx;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: week9-part3
 * @className: RpcfxClientApplication
 * @description:
 * @author: sqi
 * @date: 2022-03-12 13:57
 * @version: 1.0
 **/
@SpringBootApplication
public class RpcfxClientApplication {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        UserService userService = Rpcfx.create(UserService.class, "http://localhost:8089/");
        User user = userService.findById(1);
        System.out.println("find user id=1 from server: " + user.getName());
    }

}