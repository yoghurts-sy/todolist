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
        System.out.println(token);
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



    @PostMapping("/change") //用小写
    @ResponseBody
    public ResultInfo updateTaskTye(@RequestParam("token") String token
            ,@RequestParam("task_id") Integer task_id
            ,@RequestParam("task_type") Integer task_type
            ){

        /**
         * 判断type 然后 type取反 update,创建时间更新,完成时间去除
         */
        System.out.println(task_type);


        ResultInfo resultInfo = new ResultInfo();
        String[] split = token.split("=");
        String tokenId=split[1];
        Integer id = Integer.parseInt(tokenId);
       // System.out.println(task_id);
        try{
            UserTask userTask=usersService.updateTaskType(id,task_id);
            resultInfo.setResult(userTask);
        }catch (ParamsException p){
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
            p.printStackTrace();
        }catch (Exception e){
            resultInfo.setCode(500);
            resultInfo.setMsg("信息更新失败");
        }
        return  resultInfo;
    }

    /*@PostMapping("/insertTask") */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo insertTask(@RequestParam("token") String token,@RequestParam("task_content") String task_content){
        ResultInfo resultInfo = new ResultInfo();
        String[] split = token.split("=");
        String tokenId=split[1];
        Integer id = Integer.parseInt(tokenId);
        try{
            List<UserTask> userTask=usersService.insertTask(id,task_content);
            System.out.println("6666666666");
            resultInfo.setResult(userTask);
        }catch (ParamsException p){
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
            p.printStackTrace();
        }catch (Exception e){
            resultInfo.setCode(500);
            resultInfo.setMsg("任务添加失败");
        }
        return  resultInfo;
    }

    @PostMapping("/update")
    @ResponseBody
    public  ResultInfo updateTask(@RequestParam("token") String token,@RequestParam("task_id") Integer task_id,@RequestParam("task_content") String task_content){
        ResultInfo resultInfo = new ResultInfo();
        String[] split = token.split("=");
        String tokenId=split[1];
        Integer id = Integer.parseInt(tokenId);
        try{
            UserTask userTask=usersService.updateTask(id,task_id,task_content);
            resultInfo.setResult(userTask);
        }catch (ParamsException p){
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
            p.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            resultInfo.setCode(500);
            resultInfo.setMsg("任务更新失败");
        }
        return  resultInfo;
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResultInfo deleteTask(@RequestParam("token") String token,@RequestParam("task_id") Integer task_id){
        ResultInfo resultInfo=new ResultInfo();
        String[] split = token.split("=");
        String tokenId=split[1];
        Integer id = Integer.parseInt(tokenId);
        try{
            String result=usersService.deleteTask(id,task_id);
            resultInfo.setResult(result);
        }catch (ParamsException p){
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
            p.printStackTrace();
        }catch (Exception e){
            resultInfo.setCode(500);
            resultInfo.setMsg("任务删除失败");
            e.printStackTrace();
        }
        return  resultInfo;
    }

}
