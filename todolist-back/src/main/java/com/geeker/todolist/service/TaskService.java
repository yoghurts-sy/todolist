package com.geeker.todolist.service;

import com.geeker.todolist.pojo.UserTask;

import java.util.List;

public interface TaskService {
    public List<UserTask> userTodolist(Integer userID, Integer type);
    public UserTask updateTaskType(Integer task_userid,Integer task_id,Integer task_type);
    public List<UserTask> insertTask(Integer task_userid,String task_content);
    public UserTask updateTask(Integer task_userid,Integer task_id,String task_content);
    public String deleteTask(Integer task_userid,Integer task_id);
}
