package com.elephant.productitems.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: RedisConfig
 * @Date: 2024/09/24/17:07
 * @Description: Redis配置类
 */
@Configuration
public class RedisConfig {
    @Bean("redisTemplate")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate();
        //设置连接
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置自定义序列化方式
        setSerializerConfig(redisTemplate,redisConnectionFactory);
        return redisTemplate;
    }
    private void setSerializerConfig(RedisTemplate<String,Object> redisTemplate,RedisConnectionFactory RedisConnectionFactory){
        //普通key和HashKey采用StringRedisSerializer来序列化和反序列化
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);

        //解决查询缓存转换异常的问题
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        /**
         * 老版本，不能再使用了
         *     redisValueSerializer.setObjectMapper(objectMapper);
         */
        GenericJackson2JsonRedisSerializer redisValueSerializer = new GenericJackson2JsonRedisSerializer(objectMapper);


        //普通Value和Hash类型的Value采用jackson方式进行序列化和反序列化
        redisTemplate.setValueSerializer(redisValueSerializer);
        redisTemplate.setHashValueSerializer(redisValueSerializer);
        redisTemplate.afterPropertiesSet();
    }
}
