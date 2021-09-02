package com.geeker.todolist.dao;

import com.geeker.todolist.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersMapper {
    User queryUserByEmail(@Param("uEmail") String uEmail);
    List<User> queryUsers();
}
