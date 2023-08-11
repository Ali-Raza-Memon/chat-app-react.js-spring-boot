package com.fastech.chatapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Table(name = "chat_messages")
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String chatMessage;
    @CreatedDate
    private Date createdAt;
    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "chatMessage", cascade = CascadeType.ALL)
    @JsonIgnore
    List<ChatGroup_Message> groupMessages;

}
