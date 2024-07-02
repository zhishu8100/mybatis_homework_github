package com.szbit.test;

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
public class TestUpdate {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        TeacherExample example = new TeacherExample();
        example.createCriteria().andJobEqualTo("销售员").andAgeGreaterThan(27);
        List<Teacher> teachers = mapper.selectByExample(example);
        for (Teacher teacher : teachers) {
            teacher.setSal(teacher.getSal()+1000);
            mapper.updateByPrimaryKey(teacher);
        }
        session.close();
    }
}
