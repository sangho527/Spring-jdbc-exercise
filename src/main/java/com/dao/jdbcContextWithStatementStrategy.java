package com.dao;


import com.sun.jdi.connect.spi.Connection;

import java.sql.SQLException;

public class jdbcContextWithStatementStrategy {
    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement pstmt = stmt.makeStrategy(c);
        pstmt.executeUpdate();
        pstmt.close();
        c.close();
    }
}