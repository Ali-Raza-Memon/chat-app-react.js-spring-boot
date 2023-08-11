package com.fastech.chatapp.config;

import com.fastech.chatapp.model.Message;
import com.fastech.chatapp.model.Status;
import com.fastech.chatapp.model.User;
import com.fastech.chatapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    @Autowired
    private UserRepository userRepository;
    private final SimpMessageSendingOperations messageTemplate;

    @EventListener
    public void eventHandlerDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null){
            log.info("User disconnected: {}",username);
            User user = userRepository.findUserByUsername(username);
            user.setActive(false);
            userRepository.save(user);
            var chatMessage = Message.builder()
                    .status(Status.LEAVE)
                    .senderName(username)
                    .build();
            messageTemplate.convertAndSend("/chatroom/public",chatMessage);
        }
    }
}
