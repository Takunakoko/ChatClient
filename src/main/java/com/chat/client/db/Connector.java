package com.chat.client.db;


import com.chat.client.Configurator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by takunaka on 17.02.17.
 */
public class Connector {
    private Connection conn;

    protected Connector() {
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection("jdbc:mysql://" + Configurator.getDbHost() + ":" + Configurator.getDbPort() +
                "/ChatDatabase?" +
                "user=" + Configurator.getUsername() +
                "&password=" + Configurator.getPassword());

        return conn;
    }

}
