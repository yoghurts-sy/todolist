package com.geeker.todolist.controller;

import com.geeker.todolist.common.dto.LoginDto;
import com.geeker.todolist.entity.UserModel;
import com.geeker.todolist.service.impl.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.ParamsException;
import utils.ResultInfo;

@RestController
@RequestMapping("/geeker/api")
public class UserController {
    @Autowired
private UsersService usersService;

    @PostMapping("/login")
    @ResponseBody
    public ResultInfo userLogin(@RequestBody LoginDto user){
        ResultInfo resultInfo = new ResultInfo();
        System.out.println(user.getEmail() +" "+ user.getPassword());
        String email = user.getEmail();
        String password = user.getPassword();
       try{
            UserModel userModel=usersService.userLogin(email,password);
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
    @PostMapping("/register")
    @ResponseBody

    public ResultInfo userRegister(@RequestBody LoginDto user){
        ResultInfo resultInfo = new ResultInfo();
        String email = user.getEmail();
        String password = user.getPassword();
        try{
            UserModel userModel = usersService.userRegister(email,password);
            resultInfo.setResult(userModel);
        }catch (ParamsException p){
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
            p.printStackTrace();
        }catch (Exception e){
            resultInfo.setCode(500);
            resultInfo.setMsg("注册失败");
        }
        return resultInfo;
    }
}
