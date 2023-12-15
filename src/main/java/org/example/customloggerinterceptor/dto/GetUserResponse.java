package org.example.customloggerinterceptor.dto;

import lombok.Data;

@Data
public class GetUserResponse {

    private String id;
    private String name;

    public GetUserResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
