package com.db.jdbc;

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
public class JdbcApplicationTests {



    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void contextLoads() {

        System.out.println("--------------------------" + dataSource.getClass() + "----------------------");
        try {
            System.out.println("--------------------------" + dataSource.getConnection() + "----------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------" + jdbcTemplate + "----------------------");
    }

}
