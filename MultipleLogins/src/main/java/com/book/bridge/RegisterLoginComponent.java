package com.book.bridge;

import com.book.pojo.UserInfo;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: RegisterLoginComponent
 * @Date: 2024/09/21/21:00
 * @Description: 抽象类的实现类
 */
public class RegisterLoginComponent extends AbstractRegisterLoginComponent{
    //传入"桥梁"
    public RegisterLoginComponent(RegisterLoginFuncInterface functionInterface) {
        super(functionInterface);
    }

    @Override
    public String login(String account, String password) {
        //直接通过桥梁调用接口中的方法，接着再到具体的实现方法
        return functionInterface.login(account,password);
    }

    @Override
    public String register(UserInfo userInfo) {
        return functionInterface.register(userInfo);
    }

    @Override
    public String login3rd(HttpServletRequest request) {
        return functionInterface.login3rd(request);
    }
}
