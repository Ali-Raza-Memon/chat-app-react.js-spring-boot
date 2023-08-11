package com.fastech.chatapp.repository;

import com.fastech.chatapp.model.ChatGroup_Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatGroupMessageRepository extends JpaRepository<ChatGroup_Message,Long> {
}
