package com.book.bridge;

import com.book.pojo.UserInfo;
import com.book.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: RegisterLoginByDafult
 * @Date: 2024/09/21/20:56
 * @Description: 抽象接口的实现类【默认登录方法】
 */
@Component
public class RegisterLoginByDefault extends AbstractRegisterLoginFunc implements RegisterLoginFuncInterface{
    @Autowired
    private UserRepository userRepository;
    @Override
    public String login(String account, String password) {
        return commonLogin(account,password,userRepository);
    }

    @Override
    public String register(UserInfo userInfo) {
        return commonRegister(userInfo,userRepository);
    }

    /**
     * 这段代码对于默认的登录方式属于是垃圾代码，应当去除
     * 解决方案:
     *      模仿ArrayList、AbstractList和List接口的实现，
     *      List作为顶层的父类，AbstractList作为中间层，ArrayList作为实现类。
     *      ArrayList继承AbstractList并实现List接口。
     *
     */
//    @Override
//    public String login3rd(HttpServletRequest request) {
//        return null;
//    }
}
