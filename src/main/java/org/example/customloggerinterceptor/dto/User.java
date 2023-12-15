package org.example.customloggerinterceptor.dto;

import lombok.Data;

@Data
public class User {

    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
