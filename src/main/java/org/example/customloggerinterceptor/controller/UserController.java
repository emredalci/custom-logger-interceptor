package org.example.customloggerinterceptor.controller;

import lombok.RequiredArgsConstructor;
import org.example.customloggerinterceptor.dto.GetUserResponse;
import org.example.customloggerinterceptor.dto.User;
import org.example.customloggerinterceptor.dto.UserCreateRequest;
import org.example.customloggerinterceptor.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody UserCreateRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getWithoutDelay(@PathVariable String id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(new GetUserResponse(user.getId(), user.getName()));
    }
}
