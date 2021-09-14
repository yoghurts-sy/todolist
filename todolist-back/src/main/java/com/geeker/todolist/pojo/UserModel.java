package com.geeker.todolist.pojo;

import lombok.Data;

@Data
public class UserModel {
    private String userEmail;
    private String userToken;
    private int userId;
}
