package com.connection;

import com.sun.jdi.connect.spi.Connection;

public interface ConnectionMaker {
    Connection makeConnection() throws SQLException;
}
