package com.sxu.smartcampus_java.mapper;

import com.sxu.smartcampus_java.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM Students WHERE student_id = #{student_id}")
    @Results({
            @Result(property = "user", column = "user_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.UserMapper.findById")),
            @Result(property = "clazz", column = "class"),
    })
    Student findById(String student_id);

    @Insert("INSERT INTO Students (student_id, password, email, user_id, class, grade, college, major) " +
            "VALUES (#{student_id}, #{password}, #{email}, #{user.user_id}, #{clazz}, #{grade}, #{college}, #{major})")
    int insert(Student student);

    @Update("UPDATE Students SET password = #{password}, email = #{email}, class = #{clazz}, grade = #{grade}, " +
            "college = #{college}, major = #{major} WHERE student_id = #{student_id}")
    int update(Student student);

    @Delete("DELETE FROM Students WHERE student_id = #{student_id}")
    int delete(String student_id);

    @Select("SELECT * FROM Students")
    @Results({
            @Result(property = "user", column = "user_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.UserMapper.findById")),
            @Result(property = "clazz", column = "class"),
    })
    List<Student> findAll();
}

