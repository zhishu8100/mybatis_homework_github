package com.szbit.test;

import com.szbit.mapper.TeacherMapper;
import com.szbit.model.Teacher;
import com.szbit.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/6/29
 */
public class Test {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        //insertBatch(mapper);
        //selectByAddr(mapper);
        //countAvgSal(mapper);
        //updateByAddr(mapper);
        deleteList(mapper);
        session.close();
    }

    public static void insertBatch(TeacherMapper mapper) {
        ArrayList<Teacher> list = new ArrayList<>();
        list.add(new Teacher(1, "张三", "江苏省南京市", 35, "区域总监", 20000));
        list.add(new Teacher(2, "李四", "江苏省苏州市", 32, "销售经理", 15000));
        list.add(new Teacher(3, "王五", "四川省成都市", 26, "销售员", 8000));
        list.add(new Teacher(4, "赵六", "吉林省长春市", 27, "财务", 10000));
        list.add(new Teacher(5, "刘七", "吉林省吉林市", 24, "销售员", 6000));
        list.add(new Teacher(6, "吴八", "陕西省西安市", 31, "销售员", 7000));
        System.out.println(mapper.insertBatch(list) > 0 ? "插入成功" : "插入成功");
    }
    public static void selectByAddr(TeacherMapper mapper){
        //查询西安市所有员工信息
        Teacher teacher = new Teacher().setAddr("西安");
        mapper.selectByAddr(teacher).forEach(System.out::println);
    }
    public static void countAvgSal(TeacherMapper mapper){
        //统计在江苏省工作的员工平均工资
        Teacher teacher = new Teacher().setAddr("江苏");
        int avgSal = mapper.countAvgSal(teacher);
        System.out.println("在江苏省工作的员工平均工资:"+avgSal);
    }
    public static void updateByAddr(TeacherMapper mapper){
        //更新成都市员工的工资和职务
        Teacher teacher = new Teacher().setAddr("成都市").setJob("销售经理").setSal(12000);
        System.out.println(mapper.updateByAddr(teacher) > 0 ? "更新成功" : "更新失败");
    }
    public static void deleteList(TeacherMapper mapper){
        List<Integer> list = Arrays.asList(9, 11, 12);
        System.out.println(mapper.deleteList(list) > 0 ? "删除成功" : "删除失败");
    }

}
