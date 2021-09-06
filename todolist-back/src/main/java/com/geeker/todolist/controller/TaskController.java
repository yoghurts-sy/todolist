package com.geeker.todolist.controller;

import com.geeker.todolist.pojo.UserTask;
import com.geeker.todolist.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.ParamsException;
import utils.ResultInfo;

import java.util.List;

@RestController
@RequestMapping("/geeker/api")

public class TaskController {
    @Autowired
    private UsersService usersService;


    @PostMapping("/tasks")//finished
    @ResponseBody
    public ResultInfo userTask(@RequestParam("token") String token){
        //System.out.println(token);
        ResultInfo resultInfo = new ResultInfo();
        String[] split = token.split("=");
        String tokenId=split[1];
        Integer id = Integer.parseInt(tokenId);
        try{
            List<UserTask> userTask = usersService.userTodolist(id,0);
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

    @PostMapping("/finished")//finished
    @ResponseBody
    public ResultInfo userFinished(@RequestParam("token") String token){
        ResultInfo resultInfo = new ResultInfo();
        String[] split = token.split("=");
        String tokenId=split[1];
        Integer id = Integer.parseInt(tokenId);
        try{
            List<UserTask> userTask = usersService.userTodolist(id,1);
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
}
