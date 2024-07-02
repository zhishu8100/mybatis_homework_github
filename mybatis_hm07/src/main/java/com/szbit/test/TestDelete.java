package com.szbit.test;

import com.szbit.mapper.TeacherMapper;
import com.szbit.model.TeacherExample;
import com.szbit.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/7/2
 */
public class TestDelete {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        TeacherExample example = new TeacherExample();
        example.createCriteria().andAddrLike("%陕西省%");
        mapper.deleteByExample(example);
        session.close();
    }
}
