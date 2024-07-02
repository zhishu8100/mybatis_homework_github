package com.szbit.test;

import com.szbit.mapper.TeacherMapper;
import com.szbit.model.Teacher;
import com.szbit.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/7/2
 */
public class TestInsert {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        mapper.insert(new Teacher(7, "张丽", "江苏省南京市", 32, "销售员", 7000));
        mapper.insert(new Teacher(8, "张伟", "江苏省苏州市", 26, "职员", 5000));
        mapper.insert(new Teacher(9, "王晓", "上海市", 30, "区域总监", 20000));
        mapper.insert(new Teacher(10, "赵敏", "上海市", 25, "财务", 10000));
        session.close();
    }
}
