package com.geeker.todolist.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String email;
    private String password;
    private String token;
}
