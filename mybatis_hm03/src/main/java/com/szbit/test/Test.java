package com.szbit.test;

import com.szbit.mapper.TeacherMapper;
import com.szbit.model.Teacher;
import com.szbit.utils.SessionUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/6/27
 */
public class Test {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        //selectList(mapper);
        //selectAvgSal(mapper);
        //updateJob(mapper);
        deleteByAge(mapper);
    }
    public static void selectList(TeacherMapper mapper){
        List<Teacher> list = mapper.selectList();
        list.stream().forEach(System.out::println);
    }
    public static void selectAvgSal(TeacherMapper mapper){
        int avg = mapper.selectAvgSal("吉林省");
        System.out.println("吉林省员工的平均工资："+avg);
    }
    public static void updateJob(TeacherMapper mapper){
        System.out.println(mapper.updateJob(new Teacher().setAge(30).setJob("销售员")) > 0 ? "更新成功" : "更新失败");
    }
    public static void deleteByAge(TeacherMapper mapper){
        System.out.println(mapper.deleteByAge(35) > 0 ? "删除成功" : "删除失败");
    }
}
