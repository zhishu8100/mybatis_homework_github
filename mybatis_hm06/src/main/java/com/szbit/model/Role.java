package com.szbit.model;

import lombok.Data;

import java.util.List;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/7/1
 */
@Data
public class Role{
    private Integer rid;
    private String rname;
    private List<Permision> permisions;

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", permisions=" + permisions +
                '}';
    }
}
