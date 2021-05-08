package com.bitlab.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {

    private Connection connection;

    public void connect() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/group12db?useUnicode=true&serverTimezone=UTC&characterEncoding=utf-8", "root", "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
