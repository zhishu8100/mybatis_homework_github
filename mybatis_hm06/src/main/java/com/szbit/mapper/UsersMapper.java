package com.szbit.mapper;

import com.szbit.model.Users;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/7/1
 */
public interface UsersMapper {
    Users login(Users users);
    int updateTime(Users users);
}
