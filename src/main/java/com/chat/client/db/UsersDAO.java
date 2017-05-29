package com.chat.client.db;

import java.sql.SQLException;

/**
 * Created by takunaka on 19.04.17.
 */
public interface UsersDAO {

    public UsersEntity getUser(String login) throws SQLException;

    public void addUser(UsersEntity entity) throws SQLException;


}
