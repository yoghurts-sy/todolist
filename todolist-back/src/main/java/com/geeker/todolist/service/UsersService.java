package com.geeker.todolist.service;

import com.geeker.todolist.dao.UsersMapper;
import com.geeker.todolist.entity.UserModel;
import com.geeker.todolist.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import utils.nullOrNot;

import javax.annotation.Resource;
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

    private UserModel buildUserInfo(User user) {
        UserModel userModel=new UserModel();
        userModel.setUserEmail(user.getUser_email());
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
