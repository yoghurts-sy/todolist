package com.geeker.todolist.service;

import com.geeker.todolist.entity.UserModel;
import com.geeker.todolist.pojo.UserTask;

import java.io.IOException;
import java.util.List;

public interface UserServe {
    public UserModel userLogin(String Email, String password);//登录
    public UserModel userRegister(String Email,String password) throws IOException;//注册


}
