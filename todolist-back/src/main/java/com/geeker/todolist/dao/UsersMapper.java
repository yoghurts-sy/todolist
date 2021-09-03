package com.geeker.todolist.dao;

import com.geeker.todolist.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersMapper {
    User queryUserByEmail(@Param("uEmail") String uEmail);
    List<User> queryUsers();
    int registerUser(@Param("uEmail") String uEmail,@Param("uPassword") String uPassword);
    int updateUser(@Param("uEmail") String uEmail );
    //int selectIdByEmail(@Param("uEmail") String uEmail);
}
