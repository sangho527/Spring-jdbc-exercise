package com.dao;

import com.connection.AwsConnectionMaker;

public class UserDaoFactory {
    public UserDao awsUserDao() {
        return new UserDao(new AwsConnectionMaker());
    }
}
