package com.fastech.chatapp.controller;

import com.fastech.chatapp.dto.ChatGroupDto;
import com.fastech.chatapp.model.ChatGroup;
import com.fastech.chatapp.service.ChatGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("group")
public class ChatGroupController {

    @Autowired
    private ChatGroupService chatGroupService;


    @PostMapping("/add")
    public ResponseEntity<?> addGroup(@RequestBody ChatGroupDto dto){

        return ResponseEntity.status(HttpStatus.OK).body(chatGroupService.createGroup(dto));
    }





}
