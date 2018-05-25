package com.jsystems.apitest;

import com.jsystems.apitest.models.TestUser;
import com.jsystems.apitest.serviceDAO.UserServiceDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class JDBCTest {
    @Test
    @DisplayName("11 - JDBC")
    public void jdbcTest(){
        UserServiceDAO userServiceDAO = new UserServiceDAO();
        TestUser testUser = userServiceDAO.getOne(1l);
        System.out.println(testUser.toString());
        assertTrue(testUser.name.equals("Zdzich"));
    }
}
