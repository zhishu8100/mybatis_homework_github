package com.szbit.mapper;

import com.szbit.model.Teacher;

import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/6/27
 */
public interface TeacherMapper {
    int insert(Teacher teacher);
    int updateJob(Teacher teacher);
    int deleteByAge(int age);
    int selectAvgSal (String addr);
    List<Teacher> selectList();
}
