package com.book;

import com.book.pojo.UserInfo;
import com.book.repo.UserRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: test
 * @Date: 2024/09/17/20:45
 * @Description: 测试类
 */
@SpringBootTest
public class test {
    @Resource
    private UserRepository userRepository;

}
