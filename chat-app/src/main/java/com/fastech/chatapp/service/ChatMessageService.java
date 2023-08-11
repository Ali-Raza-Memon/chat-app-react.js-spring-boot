package com.fastech.chatapp.service;

import com.fastech.chatapp.dto.ChatMessageDto;
import com.fastech.chatapp.model.ChatMessage;
import com.fastech.chatapp.model.User;
import com.fastech.chatapp.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    private UserService userService;
    public ChatMessage addMessage(ChatMessageDto dto) {
        System.out.println("Username :"+dto.getUsername());
        System.out.println("User's Message :"+dto.getMessage());
        User user = userService.findUserByUsername(dto.getUsername());
        ChatMessage message = new ChatMessage();
        message.setChatMessage(dto.getMessage());
        message.setCreatedAt(new Date());
        message.setUser(user);
        return chatMessageRepository.save(message);
    }

}
