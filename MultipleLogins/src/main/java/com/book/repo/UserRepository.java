package com.book.repo;

import com.book.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: UserRepository
 * @Date: 2024/09/17/20:25
 * @Description: 操作数据库层、持久层
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUserName(String userName);
    UserInfo findByUserNameAndUserPassword(String account,String password);
}
