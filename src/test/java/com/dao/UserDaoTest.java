package com.dao;

import com.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)

class UserDaoTest {

    @Autowired
    ApplicationContext context;

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

