package com.geeker.todolist.service;

import com.geeker.todolist.dao.UsersMapper;
import com.geeker.todolist.entity.UserModel;
import com.geeker.todolist.pojo.User;

import com.geeker.todolist.pojo.UserTask;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import utils.nullOrNot;


import java.io.IOException;
import java.util.List;


@Service
public class UsersService {

    @Autowired
private UsersMapper usersMapper;
  //  @Transactional(rollbackFor = Exception.class)
    public UserModel userLogin(String Email,String password){
        /*判断用户名和密码是否为空*/
        checkUserLogin(Email,password);
        User user = usersMapper.queryUserByEmail(Email);
        nullOrNot.istrue(user==null,"用户名不存在");
        checkUserPassword(password,user.getUser_password());
        return buildUserInfo(user);
    }
   // @Transactional
    public UserModel userRegister(String Email,String password) throws IOException {
        User user = usersMapper.queryUserByEmail(Email);
        nullOrNot.istrue(user!=null,"用户名已存在");//判断是否已存在该用户名
        usersMapper.registerUser(Email, password);//向数据库添加用户
        usersMapper.updateUser(Email);//为用户设置token值
        User user1 = usersMapper.queryUserByEmail(Email);
        return buildUserInfo(user1);
    }


    public List<UserTask> userTodolist(Integer userID, Integer type){
     List<UserTask> userTask =usersMapper.queryUserTodolistById(userID,type);
     nullOrNot.istrue(userTask ==null,"未找到您的任务");//判断是否存在task
     return userTask;
    }


    public UserTask updateTaskType(Integer task_userid,Integer task_id){
        UserTask userTask =usersMapper.queryTask(task_userid,task_id);
        nullOrNot.istrue(userTask ==null,"该任务不存在");
        usersMapper.updateTaskType(task_userid,task_id);
        UserTask userTask1 =usersMapper.queryTask(task_userid,task_id);
        return userTask1;
    }

    public List<UserTask> insertTask(Integer task_userid,String task_content){
        nullOrNot.istrue(task_content==null,"内容不能为空");
        usersMapper.insertTask(task_userid,task_content);
        List<UserTask> userTask=usersMapper.queryUserTodolistById(task_userid,0);
        return  userTask;
    }

    public UserTask updateTask(Integer task_userid,Integer task_id,String task_content){
        nullOrNot.istrue(task_content==null,"内容不能为空");
        usersMapper.updateTask(task_userid,task_id,task_content);
        UserTask userTask=usersMapper.queryTask(task_userid,task_id);
        return userTask;
    }

    public String deleteTask(Integer task_userid,Integer task_id){
        UserTask userTask=usersMapper.queryTask(task_userid,task_id);
        nullOrNot.istrue(userTask==null,"该任务不存在");
        usersMapper.deleteTask(task_userid,task_id);
        return "删除成功";
    }


    private UserModel buildUserInfo(User user) {
        UserModel userModel=new UserModel();
        userModel.setUserEmail(user.getUser_email());
        userModel.setUserId(user.getUser_id());
        userModel.setUserToken(user.getUser_token());
        return  userModel;
    }

    private void checkUserPassword(String TruePassword, String password) {
        nullOrNot.istrue(!TruePassword.equals(password),"用户密码错误");
    }

    private void checkUserLogin(String email, String password) {
        nullOrNot.istrue(StringUtils.isEmpty(email),"用户名不能为空");
        nullOrNot.istrue(StringUtils.isEmpty(password),"密码不能为空");
    }


}
