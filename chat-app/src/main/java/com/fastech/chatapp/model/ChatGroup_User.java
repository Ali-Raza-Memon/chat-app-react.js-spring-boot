package com.fastech.chatapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "groups_users")
@Setter
@Getter
public class ChatGroup_User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JsonIgnore
    ChatGroup chatGroup;
    @ManyToOne
    @JsonIgnore
    User user;


}
