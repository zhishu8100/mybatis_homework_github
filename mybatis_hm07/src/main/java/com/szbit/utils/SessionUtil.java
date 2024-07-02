package com.szbit.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/7/1
 */
public class SessionUtil {
    public static SqlSession getSession(boolean autoCommit){
        try {
            return new SqlSessionFactoryBuilder().build(Resources.
                    getResourceAsStream("HM07_config.xml")).openSession(autoCommit);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return null;
    }
}
