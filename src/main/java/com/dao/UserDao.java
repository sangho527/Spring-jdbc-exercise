package com.dao;

import com.connection.ConnectionMaker;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class UserDao {
    ConnectionMaker connectionMaker;
    Connection connection;
    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(UserDaoFactory.User user){
        this.jdbcTemplate.update("insert into users (id, name, pasword) values (?,?,?);",
                user.getId(), user.getName(), user.getPassword());
    }

    public void deleteAll(){
        this.jdbcTemplate.update("delete from users");
    }

    public int getCount(){
        return this.jdbcTemplate.queryForObject("select count)*)from users;",Integer.class);
    }

    public UserDaoFactory.User findById(String id) {
        String sql = "select *from users where id = ?";
        RowMapper<UserDaoFactory.User> rowMapper = new RowMapper<UserDaoFactory.User>() {
            @Override
            public UserDaoFactory.User mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDaoFactory.User user = new UserDaoFactory.User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
                return user;
            }
        };
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<UserDaoFactory.User> getAll(){
        String sql = "select *from users order by id";
        RowMapper<UserDaoFactory.User> rowMapper = new RowMapper<UserDaoFactory.User>() {
            @Override
            public UserDaoFactory.User mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDaoFactory.User user = new UserDaoFactory.User(rs.getString("id"),rs.getString("name"),rs.getString("password"));
                return user;
            }
        };
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}