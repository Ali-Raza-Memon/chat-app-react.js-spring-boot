package com.fastech.chatapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "chat_groups")
@Setter
@Getter
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "group")
    private String groupName;
    @CreatedDate
    private Date createdAt;

    @Transient
    List<Message> messageList;
    @OneToMany(mappedBy = "chatGroup", cascade = CascadeType.ALL)
    @JsonIgnore
    List<ChatGroup_Message> groupMessages ;


    @Transient
    List<User> userList;
    @OneToMany(mappedBy = "chatGroup", cascade = CascadeType.ALL)
    @JsonIgnore
    List<ChatGroup_User> groupUsers ;


}
