package com.szbit.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szbit.mapper.TeacherMapper;
import com.szbit.model.Teacher;
import com.szbit.model.TeacherExample;
import com.szbit.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/7/2
 */
public class TestQuery {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        TeacherExample example = new TeacherExample();
        example.createCriteria().andAddrLike("%江苏%");
        PageHelper.startPage(2,3);
        List<Teacher> teachers = mapper.selectByExample(example);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        List<Teacher> list = pageInfo.getList();
        list.forEach(System.out::println);
        session.close();
    }
}
