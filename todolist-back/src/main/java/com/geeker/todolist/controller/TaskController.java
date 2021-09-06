/*package com.geeker.todolist.controller;

import com.geeker.todolist.pojo.UserTask;
import com.geeker.todolist.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.ParamsException;
import utils.ResultInfo;
@RestController
@RequestMapping("/geeker/api")

public class TaskController {
    @Autowired
    private UsersService usersService;
    @PostMapping("/findTask")
    @ResponseBody
    public ResultInfo userTask(@RequestBody String token, int type){
        ResultInfo resultInfo = new ResultInfo();
        String[] split = token.split("=");
        Integer id = Integer.parseInt(split[1]);
        try{
            UserTask userTask = usersService.userTodolist(id,type);
            resultInfo.setResult(userTask);
        }catch(ParamsException p){
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
            p.printStackTrace();
        }catch (Exception e){
            resultInfo.setCode(500);
            resultInfo.setMsg("查找失败");
        }
        return resultInfo;
    }
}*/
