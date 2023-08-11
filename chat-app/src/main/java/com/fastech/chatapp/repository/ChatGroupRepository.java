package com.fastech.chatapp.repository;

import com.fastech.chatapp.model.ChatGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatGroupRepository extends JpaRepository<ChatGroup,Long> {
    @Query("SELECT group FROM ChatGroup group WHERE group.groupName=?1")
    ChatGroup findGroupByName(String name);


}
