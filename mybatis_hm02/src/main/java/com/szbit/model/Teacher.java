package com.szbit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/6/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Teacher {
    private Integer id;
    private String name;
    private String addr;
    private Integer age;
    private String job;
    private Integer sal;
}