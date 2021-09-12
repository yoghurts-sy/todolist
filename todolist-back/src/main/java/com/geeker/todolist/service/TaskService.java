package com.geeker.todolist.service;

import com.geeker.todolist.dao.UsersMapper;
import com.geeker.todolist.pojo.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.nullOrNot;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TaskService implements TaskServe{


    @Autowired
    private UsersMapper usersMapper;

    public List<UserTask> userTodolist(Integer userID, Integer type){
        List<UserTask> userTask =usersMapper.queryUserTodolistById(userID,type);
        nullOrNot.istrue(userTask ==null,"未找到您的任务");//判断是否存在task
        return userTask;
    }

    /**
     * 根据接收
     *
     */
    public UserTask updateTaskType(Integer task_userid,Integer task_id,Integer task_type){
        UserTask userTask = usersMapper.queryTask(task_userid,task_id);
        nullOrNot.istrue(userTask == null,"该任务不存在");
        if(task_type==0){
            LocalDateTime localDateTime=LocalDateTime.now();
            usersMapper.updateTaskType(task_userid,task_id,1,localDateTime);
        }else if(task_type==1){
            usersMapper.updateTaskType(task_userid,task_id,0,null);
        }


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

}
