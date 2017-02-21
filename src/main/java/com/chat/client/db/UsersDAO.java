package com.chat.client.db;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by takunaka on 17.02.17.
 */
@Component
public class UsersDAO {

    public UsersEntity getUser(String login) throws SQLException {
        Connection conn = new Connector().getConnection();
        Statement st = conn.createStatement();
        UsersEntity ue = new UsersEntity();

        ResultSet rs = st.executeQuery("SELECT * FROM ChatDatabase.USERS WHERE username =\" " + login + "\"");
        while (rs.next()){
            ue.setId(rs.getInt("id"));
            ue.setPassword(rs.getString("password"));
            ue.setUsername(rs.getString("username"));
        }
        rs.close();
        st.close();
        conn.close();
        return ue;
    }

    public void addUser(UsersEntity entity) throws SQLException {
        Connection conn = new Connector().getConnection();
        Statement st = conn.createStatement();
        st.execute("INSERT INTO ChatDatabase.USERS (username, password) " +
                "VALUES (\""+ entity.getUsername() + "\", \"" + entity.getPassword() + "\")");
        st.close();
        conn.close();
    }



}
