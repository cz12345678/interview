package com.learn.webjsp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebJspApplicationTests {

    // 测试是否 数据源 是否装配成功

    @Autowired
    private DataSource dataSource;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
        System.err.println("dataSource \t---------------------" + dataSource.getClass());
        try {
            System.err.println("connection \t---------------------" + dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.err.println("jdbcTemplate \t----------------------" + jdbcTemplate);
    }

}
