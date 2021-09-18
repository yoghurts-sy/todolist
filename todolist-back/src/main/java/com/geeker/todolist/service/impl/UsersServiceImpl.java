package com.geeker.todolist.service.impl;
import com.geeker.todolist.dao.UsersMapper;
import com.geeker.todolist.pojo.User;
import com.geeker.todolist.pojo.UserModel;
import com.geeker.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.geeker.todolist.utils.nullOrNot;
import java.io.IOException;
@Service
public class UsersServiceImpl implements UserService {
    @Autowired
private UsersMapper usersMapper;


    public UserModel userLogin(String Email, String password){
        checkUserLogin(Email,password);
        User user = usersMapper.queryUserByEmail(Email);
        nullOrNot.istrue(user==null,"用户名不存在");
        checkUserPassword(password,user.getUser_password());
        return buildUserInfo(user);
    }
    @Transactional
    public UserModel userRegister(String Email,String password) throws IOException {
        User user = usersMapper.queryUserByEmail(Email);
        nullOrNot.istrue(user!=null,"用户名已存在");//判断是否已存在该用户名
        usersMapper.registerUser(Email, password);//向数据库添加用户
        usersMapper.updateUser(Email);//为用户设置token值
        User user1 = usersMapper.queryUserByEmail(Email);
        return buildUserInfo(user1);
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
