package com.dao;

import com.sun.jdi.connect.spi.Connection;

public interface StatementStrategy {
    PreparedStatement makePreparedStatement(Connection c);
}