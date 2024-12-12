package com.sxu.smartcampus_java.mapper;

import com.sxu.smartcampus_java.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM Users WHERE user_id = #{user_id}")
    User findById(String user_id);

    @Insert("INSERT INTO Users (user_id, password, email, role) VALUES (#{user_id}, #{password}, #{email}, #{role})")
    int insert(User user);

    @Update("UPDATE Users SET password = #{password}, email = #{email}, role = #{role} WHERE user_id = #{user_id}")
    int update(User user);

    @Delete("DELETE FROM Users WHERE user_id = #{user_id}")
    int delete(String user_id);

    @Select("SELECT * FROM Users")
    List<User> findAll();
}
