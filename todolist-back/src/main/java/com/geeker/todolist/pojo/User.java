package com.geeker.todolist.pojo;

import lombok.Data;

@Data
public class User {
    private Integer user_id;
    private String user_email;
    private String user_password;
    private String user_token;
    public User(String email,String password){
        this.user_email=email;
        this.user_password=password;
    }
}
