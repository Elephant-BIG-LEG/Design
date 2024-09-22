package com.book.bridge;

import com.book.pojo.UserInfo;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: AbstractRegisterLoginComponent
 * @Date: 2024/09/21/20:59
 * @Description: 抽象类【暴露给客户端】
 */
public abstract class AbstractRegisterLoginComponent {
    //需要连接抽象接口【面向接口编程】
    protected RegisterLoginFuncInterface functionInterface;
    //有参构造器初始化functionInterface属性
    public AbstractRegisterLoginComponent(RegisterLoginFuncInterface functionInterface){
        validate(functionInterface);
        this.functionInterface = functionInterface;
    }
    public final void validate(RegisterLoginFuncInterface functionInterface){
        if(functionInterface == null){
            throw new UnsupportedOperationException("Unknown register/login function type");
        }
    }
    public abstract String login(String account,String password);

    public abstract String register(UserInfo userInfo);

    public abstract String login3rd(HttpServletRequest request);
}
