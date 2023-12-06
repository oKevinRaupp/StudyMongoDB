package com.kevinraupp.mongodb.dto;

import com.kevinraupp.mongodb.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }
}
