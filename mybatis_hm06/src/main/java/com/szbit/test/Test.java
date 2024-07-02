package com.szbit.test;

import com.szbit.mapper.UsersMapper;
import com.szbit.model.Permision;
import com.szbit.model.Role;
import com.szbit.model.Users;
import com.szbit.utils.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/7/1
 */
public class Test {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入用户密码：");
        String pwd = sc.nextLine();
        Users u = new Users().setUname(name).setPwd(pwd);
        Users user = mapper.login(u);
        if (user == null) {
            System.out.println("登录失败");
        } else {
            System.out.println("欢迎用户:" + user.getUname());
            List<Role> roles = user.getRoles();
            System.out.println("当前用户有" + roles.size() + "个角色：");
            int index = 0;
            for (Role role : roles) {
                System.out.println("\t角色" + (++index) + ":" + role.getRname());
                List<Permision> permisions = role.getPermisions();
                System.out.println("\t\t\t" + role.getRname() + "权限：");
                for (Permision permision : permisions) {
                    System.out.println("\t\t\t\t<a href = '" + permision.getUrl() + "'>" + permision.getPname() + "</a>");
                }
            }
            Users users = user.setLasttime(LocalDateTime.now());
            mapper.updateTime(users);
        }
    }
}
