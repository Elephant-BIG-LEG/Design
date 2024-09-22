package com.book.bridge;

import com.book.pojo.UserInfo;
import com.book.repo.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: RegisterLoginByDafult
 * @Date: 2024/09/21/20:56
 * @Description: 抽象接口的实现类【Gitee登录方式】
 */
@Component
public class RegisterLoginByGitee implements RegisterLoginFuncInterface{
    @Autowired
    private UserRepository userRepository;
    @Override
    public String login(String account, String password) {
        return null;
    }

    @Override
    public String register(UserInfo userInfo) {
        return null;
    }

    @Override
    public String login3rd(HttpServletRequest request) {
        return null;
    }
}
