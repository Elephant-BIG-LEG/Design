package com.book.controller;

import com.book.pojo.UserInfo;
import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: UserController
 * @Date: 2024/09/17/20:24
 * @Description: 用户控制层
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public String login(String account,String password){
        return userService.login(account,password);
    }


    @PostMapping("/register")
    public String register(@RequestBody UserInfo userInfo){
        return userService.register(userInfo);
    }

}
