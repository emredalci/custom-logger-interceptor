package org.example.customloggerinterceptor.service;

import lombok.RequiredArgsConstructor;
import org.example.customloggerinterceptor.dto.User;
import org.example.customloggerinterceptor.dto.UserCreateRequest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final StringRedisTemplate redisTemplate;
    public String create(UserCreateRequest request) {
        String id = UUID.randomUUID().toString();
        redisTemplate.opsForValue().setIfAbsent(id, request.getName());
        return id;
    }

    public User getUser(String id) {
        String name = redisTemplate.opsForValue().get(id);
        return new User(id, name);

    }
}
