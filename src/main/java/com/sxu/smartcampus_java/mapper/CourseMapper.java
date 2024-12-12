package com.sxu.smartcampus_java.mapper;

import com.sxu.smartcampus_java.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {

    // 查询所有课程
    @Select("SELECT * FROM Courses")
    @Results({
            @Result(property = "teacher", column = "teacher_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.TeacherMapper.findById"))
    })
    List<Course> findAll();

    // 根据课程ID查询课程
    @Select("SELECT * FROM Courses WHERE course_id = #{course_id}")
    @Results({
            @Result(property = "teacher", column = "teacher_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.TeacherMapper.findById"))
    })
    Course findById(String course_id);

    // 根据课程名称查询课程
    @Select("SELECT * FROM Courses WHERE course_name = #{course_name}")
    @Results({
            @Result(property = "teacher", column = "teacher_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.TeacherMapper.findById"))
    })
    List<Course> findByCourseName(String course_name);

    // 根据教师ID查询课程
    @Select("SELECT * FROM Courses WHERE teacher_id = #{teacher_id}")
    @Results({
            @Result(property = "teacher", column = "teacher_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.TeacherMapper.findById"))
    })
    List<Course> findByTeacherId(String teacher_id);

    // 插入课程
    @Insert("INSERT INTO Courses (course_id, course_name, credits, classroom, teacher_id) " +
            "VALUES (#{course_id}, #{course_name}, #{credits}, #{classroom}, #{teacher.teacher_id})")
    int insert(Course course);

    // 更新课程信息
    @Update("UPDATE Courses SET course_name = #{course_name}, credits = #{credits}, " +
            "classroom = #{classroom}, teacher_id = #{teacher.teacher_id} WHERE course_id = #{course_id}")
    int update(Course course);

    // 根据课程ID删除课程
    @Delete("DELETE FROM Courses WHERE course_id = #{course_id}")
    int delete(String course_id);

    // 根据课程名称和教师ID查询课程
    @Select("SELECT * FROM Courses WHERE course_name = #{course_name} AND teacher_id = #{teacher_id}")
    @Results({
            @Result(property = "teacher", column = "teacher_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.TeacherMapper.findById"))
    })
    List<Course> findByCourseNameAndTeacherId(String course_name, String teacher_id);

    // 根据课程名称更新课程信息
    @Update("UPDATE Courses SET course_name = #{course_name}, credits = #{credits}, " +
            "classroom = #{classroom}, teacher_id = #{teacher.teacher_id} WHERE course_name = #{course_name}")
    int updateByCourseName(Course course);

    // 根据教师ID删除课程
    @Delete("DELETE FROM Courses WHERE teacher_id = #{teacher_id}")
    int deleteByTeacherId(String teacher_id);
}


