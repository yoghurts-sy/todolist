package com.geeker.todolist.entity;

public class UserModel {
    private String userEmail;
    private String userToken;
    private int userId;
    public String getUserEmail() {
        return userEmail;
    }
    public java.lang.String getUserToken() {
        return userToken;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }
    public void setUserToken(String userToken){
        this.userToken = userToken;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
