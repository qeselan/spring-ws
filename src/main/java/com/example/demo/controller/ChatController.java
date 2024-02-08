package com.example.demo.controller;

import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final UserService userService;

    @GetMapping("/test")
    ResponseEntity<String> test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        log.info("User {} made a request", username);
        return ResponseEntity.ok("success");
    }


    @MessageMapping("/online")
    ResponseEntity<String> goOnline() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userService.goOnline(username);
        return ResponseEntity.ok("success");

    }
//
//    // Get active users
//    @MessageMapping("/active-users")
//    @SendTo()
//    public User[] getUsers(User user) {
//        User[] userList = activeUsers.stream().map(User::new).toArray(User[]::new);
//
//    }
}