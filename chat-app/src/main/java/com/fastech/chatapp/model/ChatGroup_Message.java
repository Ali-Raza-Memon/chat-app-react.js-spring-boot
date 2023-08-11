package com.fastech.chatapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "groups_messages")
@Setter
@Getter
public class ChatGroup_Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JsonIgnore
    ChatGroup chatGroup;
    @ManyToOne
    @JsonIgnore
    ChatMessage chatMessage;


}
