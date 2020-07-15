package com.example.myspringbootsessionwithmysqlredis.repository;

import com.example.myspringbootsessionwithmysqlredis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("from User u where u.account=:account")
    User findByAccount(String account);
}
