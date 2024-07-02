package com.szbit.test;

import com.szbit.Utils.SessionUtil;
import com.szbit.model.Teacher;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/6/27
 */
public class TestCRUDObject {
    public static void main(String[] args) {
//        selectList();
//        selectByAddr();
//        updateByAgeAndJob();
        deleteByAge();
    }

    public static void selectList() {
        SqlSession session = SessionUtil.getSession(true);
        List<Teacher> list = session.selectList("Teacher.selectList");
        list.stream().forEach(System.out::println);
    }

    public static void selectByAddr() {
        SqlSession session = SessionUtil.getSession(true);
        int avg = session.selectOne("Teacher.selectByAddr", "吉林省");
        System.out.println("吉林省员工的平均工资:" + avg);
    }

    public static void updateByAgeAndJob() {
        SqlSession session = SessionUtil.getSession(true);
        Teacher teacher = new Teacher();
        teacher.setAge(30).setJob("销售员");
        int update = session.update("Teacher.updateByAgeAndJob", teacher);
        System.out.println(update > 0 ? "成功" : "失败");
    }
    public static void deleteByAge(){
        SqlSession session = SessionUtil.getSession(true);
        int delete = session.delete("deleteByAge", 35);
        System.out.println(delete > 0 ? "成功" : "失败");
    }
}
