package com.sxu.smartcampus_java.mapper;

import com.sxu.smartcampus_java.entity.Score;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

@Mapper
public interface ScoreMapper {
    @Select("SELECT * FROM Score WHERE student_id = #{student_id} AND course_id = #{course_id}")
    @Results({
            @Result(property = "student", column = "student_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.StudentMapper.findById")),
            @Result(property = "course", column = "course_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.CourseMapper.findById")),
            @Result(property = "id.student_id", column = "student_id"),
            @Result(property = "id.course_id", column = "course_id")
    })
    Score findById(String student_id, String course_id);

    @Insert("INSERT INTO Score (student_id, course_id, result) VALUES (#{student.student_id}, #{course.course_id}, #{result})")
    int insert(Score score);

    @Update("UPDATE Score SET result = #{result} WHERE student_id = #{student.student_id} AND course_id = #{course.course_id}")
    int update(Score score);

    @Delete("DELETE FROM Score WHERE student_id = #{student_id} AND course_id = #{course_id}")
    int delete(@Param("student_id") String student_id, @Param("course_id") String course_id);

    @Select("SELECT * FROM Score")
    @Results({
            @Result(property = "student", column = "student_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.StudentMapper.findById")),
            @Result(property = "course", column = "course_id",
                    one = @One(select = "com.sxu.smartcampus_java.mapper.CourseMapper.findById")),
            @Result(property = "id.student_id", column = "student_id"),
            @Result(property = "id.course_id", column = "course_id")
    })
    List<Score> findAll();
}

