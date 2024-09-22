package com.book.adapter;

import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: Login3rdAdapter_Object
 * @Date: 2024/09/21/19:49
 * @Description: 对象设配器
 */
@Component
public class Login3rdAdapter_Object implements Login3rdTarget {
    @Autowired
    private UserService userService;
    @Override
    public String loginByQQ(String openId, String qqAccessToken) {
        return null;
    }

    @Override
    public String loginByWechat(String openId, String wxAccessToken, String wxAccessTokenKey) {
        return null;
    }

    @Override
    public String loginByWeibo(String uid, String accessToken) {
        return null;
    }
}
