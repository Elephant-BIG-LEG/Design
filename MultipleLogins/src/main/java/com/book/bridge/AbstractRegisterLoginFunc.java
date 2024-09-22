package com.book.bridge;

import com.book.pojo.UserInfo;
import com.book.repo.UserRepository;
import jakarta.servlet.http.HttpServletRequest;


import java.util.Date;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: AbstractRegisterLoginFunc
 * @Date: 2024/09/21/21:25
 * @Description: 解决垃圾代码的中间类
 */
public abstract class AbstractRegisterLoginFunc implements RegisterLoginFuncInterface{
    //新增commonLogin方法，新增userRepository参数
    public String commonLogin(String account,String password, UserRepository userRepository){
        UserInfo userInfo = userRepository.findByUserNameAndUserPassword(account,password);
        //将原LoginServiceImpl中的login方法的代码移至该方法，减少重复代码，提高代码可读性
        if (userInfo == null) {
           return "account / password error";
        }
        return "Login Success";
    }

    //新增commonRegister方法，新增userRepository参数
    public String commonRegister(UserInfo userInfo, UserRepository userRepository){
        if(commonCheckUserExists(userInfo.getUserName(),userRepository)){
            throw new RuntimeException("User already exists");
        }
        userInfo.setCreateDate(new Date());
        userRepository.save(userInfo);
        return "Login Success";
    }
    public boolean commonCheckUserExists(String userName,UserRepository userRepository){
        UserInfo userInfo = userRepository.findByUserName(userName);
        if(userInfo == null){
            return true;
        }
        return false;
    }
    @Override
    public String login(String account, String password) {
       throw new UnsupportedOperationException();
    }

    @Override
    public String register(UserInfo userInfo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String login3rd(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }
}
