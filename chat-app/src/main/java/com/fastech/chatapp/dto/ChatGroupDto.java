package com.fastech.chatapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class ChatGroupDto {
    private Integer id;

    private String groupName;
    private String userName;
}
