package com.elephant.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: RedisCommonProcess
 * @Date: 2024/09/22/21:14
 * @Description: TODO
 */
@Component
public class RedisCommonProcess {
    //依赖注入我们定义好的 RedisTemplate
    @Autowired
    private RedisTemplate redisTemplate;
    //通过key获取value
    public Object get(String key) {
        if(key == null){
            throw new UnsupportedOperationException("Redis key could not be null");
        }
        return redisTemplate.opsForValue().get(key);
    }
    //向Redis 中存入key ：value
    public void set(String key,Object value) {
        redisTemplate.opsForValue().set(key, value);
    }
    //向Redis中存入key：value数据对，并支持过期时间
    public void set(String key,Object value,long time){
        if(time > 0){
            redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
        }else{
            set(key,value);
        }
    }
}
