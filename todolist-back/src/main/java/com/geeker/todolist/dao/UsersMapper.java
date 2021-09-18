package com.geeker.todolist.dao;
import com.geeker.todolist.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UsersMapper {
    User queryUserByEmail(@Param("uEmail") String uEmail);

    int registerUser(@Param("uEmail") String uEmail,@Param("uPassword") String uPassword);

    int updateUser(@Param("uEmail") String uEmail );
}
