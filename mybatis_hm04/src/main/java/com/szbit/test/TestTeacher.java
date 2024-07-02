package com.szbit.test;

import com.szbit.mapper.TeacherMapper;
import com.szbit.model.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/6/29
 */
public class TestTeacher {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources
                .getResourceAsStream("HM04_config.xml")).openSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        //selectList(mapper);
        //selectId(mapper);
        //insert(mapper);
        //update(mapper);
        delete(mapper);
    }
    public static void selectList(TeacherMapper mapper){
        List<Teacher> list = mapper.selectList();
        list.stream().forEach(System.out::println);
    }
    public static void selectId(TeacherMapper mapper){
      Teacher teacher = mapper.selectId(2);
        System.out.println(teacher);
    }
    public static void insert(TeacherMapper mapper){
        Teacher teacher = new Teacher(null, "李白", "甘肃兰州", 40, "诗人", 20000);
        System.out.println(mapper.insert(teacher)>0?"插入成功":"插入失败");
    }

    public static void update(TeacherMapper mapper){
        Teacher teacher = new Teacher(7, "杜甫", "河南洛阳", 45, "诗人", 22000);
        System.out.println(mapper.update(teacher)>0?"更新成功":"更新失败");
    }
    public static void delete(TeacherMapper mapper){
        System.out.println(mapper.delete(7)>0?"删除成功":"删除失败");
    }
}
