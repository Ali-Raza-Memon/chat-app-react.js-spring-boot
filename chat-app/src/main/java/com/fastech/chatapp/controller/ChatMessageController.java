package com.fastech.chatapp.controller;

import com.fastech.chatapp.service.ChatMessageService;
import com.fastech.chatapp.dto.ChatMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@CrossOrigin("*")
public class ChatMessageController{
    @Autowired
    private ChatMessageService chatMessageService;

    @PostMapping("/add")
    public ResponseEntity<?> addChatMessage(@RequestBody ChatMessageDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(chatMessageService.addMessage(dto));
    }









}
