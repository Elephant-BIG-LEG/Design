package com.book.service;

import com.book.pojo.UserInfo;
import com.book.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: UserService
 * @Date: 2024/09/17/20:25
 * @Description: 逻辑处理层
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String login(String name,String password){
        UserInfo userInfo = userRepository.findByUserNameAndUserPassword(name, password);
        if(userInfo == null){
            return "Account / password Error";
        }
        return "Login Success";
    }

    public String register(UserInfo userInfo){
        System.out.println(userInfo);
       if(checkUserExists(userInfo.getUserName())){
           throw new RuntimeException("User Already Exists");
       }
       userInfo.setCreateDate(new Date());
       userRepository.save(userInfo);
       return "Register Success";
    }

    public boolean checkUserExists(String username){
        UserInfo userInfo = userRepository.findByUserName(username);
        if(userInfo == null){
            return false;
        }
        return true;
    }

}
