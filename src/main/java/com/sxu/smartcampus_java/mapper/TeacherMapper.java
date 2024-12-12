package com.sxu.smartcampus_java.mapper;

import com.sxu.smartcampus_java.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("SELECT * FROM Teachers WHERE teacher_id = #{teacher_id}")
    @Results({
            @Result(property = "user", column = "user_id", one = @One(select = "com.sxu.smartcampus_java.mapper.UserMapper.findById"))
    })
    Teacher findById(String teacher_id);

    @Insert("INSERT INTO Teachers (teacher_id, password, email, user_id, name, college) " +
            "VALUES (#{teacher_id}, #{password}, #{email}, #{user.user_id}, #{name}, #{college})")
    int insert(Teacher teacher);

    @Update("UPDATE Teachers SET password = #{password}, email = #{email}, name = #{name}, college = #{college} " +
            "WHERE teacher_id = #{teacher_id}")
    int update(Teacher teacher);

    @Delete("DELETE FROM Teachers WHERE teacher_id = #{teacher_id}")
    int delete(String teacher_id);

    @Select("SELECT * FROM Teachers")
    @Results({
            @Result(property = "user", column = "user_id", one = @One(select = "com.sxu.smartcampus_java.mapper.UserMapper.findById"))
    })
    List<Teacher> findAll();
}

