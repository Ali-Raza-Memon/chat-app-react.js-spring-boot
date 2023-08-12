package com.fastech.chatapp.service;

import com.fastech.chatapp.dto.ChatGroupDto;
import com.fastech.chatapp.model.ChatGroup;

import com.fastech.chatapp.model.ChatGroup_Message;
import com.fastech.chatapp.model.ChatGroup_User;
import com.fastech.chatapp.model.User;
import com.fastech.chatapp.repository.ChatGroupMessageRepository;
import com.fastech.chatapp.repository.ChatGroupRepository;

import com.fastech.chatapp.repository.ChatGroupUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChatGroupService {
    @Autowired
    private ChatGroupRepository chatGroupRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ChatGroupUserRepository groupUserRepository;


    //username
    //groupname
    public String createGroup(ChatGroupDto dto){
        User user = userService.findUserByUsername(dto.getUserName()); // got the user object
        ChatGroup chatGroup = findGroupByName(dto.getGroupName());
        if(chatGroup != null)// got the group object
            return "Group is already exist. Please use different name";
        else {
            ChatGroup newGroup = new ChatGroup();
            newGroup.setCreatedAt(new Date());
            newGroup.setGroupName(dto.getGroupName());
            ChatGroup savedGroup = chatGroupRepository.save(newGroup);
            ChatGroup_User chatGroupUser = new ChatGroup_User();
            chatGroupUser.setUser(user);
            chatGroupUser.setChatGroup(savedGroup);
            groupUserRepository.save(chatGroupUser);
            return "Group is added";
        }

    }

    public ChatGroup findGroupByName(String name){
        return chatGroupRepository.findGroupByName(name);
    }


}
