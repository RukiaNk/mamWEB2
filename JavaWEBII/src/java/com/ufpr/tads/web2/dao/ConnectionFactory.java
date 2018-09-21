/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {

    public Connection getConnection() throws SQLException {
        try {
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost/bd_web2";
            String dbUser = "root";
            String dbPwd = "";
            Class.forName(dbDriver);
            return DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
