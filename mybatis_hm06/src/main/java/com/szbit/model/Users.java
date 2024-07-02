package com.szbit.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/7/1
 */
@Data
@Accessors(chain = true)
public class Users {
    private Integer uid;
    private String uname;
    private String pwd;
    private LocalDateTime lasttime;
    private List<Role> roles;

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", lasttime=" + lasttime +
                ", roles=" + roles +
                '}';
    }
}
