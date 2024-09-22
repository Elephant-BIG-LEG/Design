package com.book.adapter;

import com.book.repo.UserRepository;
import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: Login3rdAdapter
 * @Date: 2024/09/21/19:29
 * @Description: 类设配器
 * 这里可以使用对象设配器【为什么选择类设配器，是因为对象设配器使用的@Service只能提供给@Controller@Service标记的类使用】
 */

/**
 * Login3rdAdapter作为设配器Adapter角色，为什么要继承作为源Adapter角色的UserService类？
 *      答：为了复用。为设配新的功能做准备，在使用其他第三方的登录时，也需要使用本地的登录和注册方法。
 * Login3rdAdapter作为设配器Adapter角色，为什么要实现Login3rdTarget接口？
 *      答：为了扩展。Login3rdTarget中有最新的第三方登录方法loginBy*()。
 *          Login3rdAdapter作为对Login3rdTarget的扩展，需要实现这些方法。
 */
@Component
public class Login3rdAdapter_Class extends UserService implements Login3rdTarget{
    @Autowired
    private UserRepository userRepository;
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
