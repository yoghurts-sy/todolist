package com.geeker.todolist.controller;

import com.geeker.todolist.entity.UserModel;
import com.geeker.todolist.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import utils.ParamsException;
import utils.ParamsException;
import utils.ResultInfo;

import javax.annotation.Resource;
import javax.annotation.Resources;

@RestController
@RequestMapping("/geeker/api")
public class UserController {
    @Autowired
private UsersService usersService;

    @GetMapping("login")
    @ResponseBody
    public ResultInfo userLogin(String userEmail,String userPassword){
        ResultInfo resultInfo = new ResultInfo();
        System.out.println(userEmail +" "+userPassword);

       try{
            UserModel userModel=usersService.userLogin(userEmail,userPassword);
            resultInfo.setResult(userModel);
        }catch (ParamsException p){
            resultInfo.setCode(p.getCode());
           resultInfo.setMsg(p.getMsg());
           p.printStackTrace();
       }catch (Exception e){
           resultInfo.setCode(500);
            resultInfo.setMsg("登录失败");
        }



            return resultInfo;
    }

    /*
    feature 1: 调用数据库，完成后端登录逻辑的验证
     */
}
