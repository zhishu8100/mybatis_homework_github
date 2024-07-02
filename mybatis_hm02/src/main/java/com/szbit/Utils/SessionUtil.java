package com.szbit.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZhiShu8100
 * @project mybatis_homework_
 * @date 2024/6/27
 */
public class SessionUtil {
    public static SqlSession getSession(boolean autoCommit){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("HM02_config.xml");
        } catch (IOException e) {
            e.getStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(inputStream).openSession(autoCommit);
    }
}
