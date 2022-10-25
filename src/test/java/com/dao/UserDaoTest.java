package com.dao;

import com.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndGet() {
        UserDao userDao = new UserDaoFactory().awsUserDao();
        String id = "1";
        userDao.add(new User(id, "Sangho", "1234"));
        User user = userDao.findById(id);
        assertEquals("Sangho", user.getName());
        assertEquals("1234", user.getPassword());
    }
}
