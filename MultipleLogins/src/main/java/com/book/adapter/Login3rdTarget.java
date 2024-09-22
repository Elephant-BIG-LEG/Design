package com.book.adapter;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: Login3rdTarget
 * @Date: 2024/09/21/19:33
 * @Description: 满足面向接口编程
 */
public interface Login3rdTarget {
    public String loginByQQ(String openId, String qqAccessToken);
    public String loginByWechat(String openId, String wxAccessToken, String wxAccessTokenKey);
    public String loginByWeibo(String uid, String accessToken);
}
