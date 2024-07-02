package com.szbit.mapper;

import com.szbit.model.Teacher;

import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/6/29
 */
public interface TeacherMapper {
    int insertBatch(List<Teacher> list);
    List<Teacher> selectByAddr(Teacher teacher);
    int countAvgSal(Teacher teacher);
    int updateByAddr(Teacher teacher);
    int deleteList(List<Integer> list);
}
