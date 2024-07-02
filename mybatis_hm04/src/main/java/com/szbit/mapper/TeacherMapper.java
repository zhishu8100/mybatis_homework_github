package com.szbit.mapper;

import com.szbit.model.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/6/29
 */
public interface TeacherMapper {
    @Insert("insert into teacher values (default,#{name},#{addr},#{age},#{job},#{sal})")
    int insert(Teacher teacher);
    @Delete("delete from teacher where id = #{id}")
    int delete(Integer id);
    @Update("update teacher set name= #{name},addr=#{addr},age=#{age},job=#{job},sal=#{sal} where id=#{id}")
    int update(Teacher teacher);
    @Select("select * from teacher where id = #{id}")
    Teacher selectId(Integer id);
    @Select("select * from teacher")
    List<Teacher> selectList();
}
