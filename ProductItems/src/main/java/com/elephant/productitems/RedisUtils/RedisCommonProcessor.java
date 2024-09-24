package com.elephant.productitems.RedisUtils;

import ch.qos.logback.core.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: RedisCommonProcessor
 * @Date: 2024/09/24/17:13
 * @Description: 自定义redis工具类
 */
@Component
public class RedisCommonProcessor {
    //注入定义好的redisTemplate
    @Autowired
    private RedisTemplate redisTemplate;
    //通过key获取value
    public Object get(String key){
        if(key == null){
            throw new UnsupportedOperationException("key could not be null！");
        }
        return redisTemplate.opsForValue().get(key);
    }
    //向redis存入key：value键值对
    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }
    //向redis存入key：value键值对并设置过期时间
    public void set(String key,String value,long time){
        if(time > 0){
            redisTemplate.opsForValue().set(key,value, time, TimeUnit.SECONDS);
        }else{
            set(key,value);
        }
    }
}
