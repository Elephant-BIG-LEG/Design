package com.book.bridge;

import com.book.pojo.UserInfo;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: RegisterLoginFuncInterface
 * @Date: 2024/09/21/21:26
 * @Description: 抽象接口【不暴露】
 */
public interface RegisterLoginFuncInterface {
    public String login(String account,String password);

    public String register(UserInfo userInfo);

    public String login3rd(HttpServletRequest request);
}
