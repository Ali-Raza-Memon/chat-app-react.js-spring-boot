package com.fastech.chatapp.repository;

import com.fastech.chatapp.model.ChatGroup_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatGroupUserRepository extends JpaRepository<ChatGroup_User,Long> {

}
