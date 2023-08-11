package com.fastech.chatapp.repository;

import com.fastech.chatapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u where u.username=?1")
    User findUserByUsername (String username);

    @Query("SELECT u.username FROM User u WHERE u.active = true")
    List<String> findNamesOfActiveUsers();



}
