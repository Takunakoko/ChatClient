package com.chat.client.web.services;

import com.chat.client.db.UsersDAO;
import com.chat.client.db.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by takunaka on 20.02.17.
 */
@Service
public class UsersService {
    @Autowired
    private UsersDAO usersDAO;

    public boolean auth(String login, String pass) {
        UsersEntity ue = new UsersEntity();

        try {
            ue = usersDAO.getUser(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (ue != null && ue.getPassword() != null){
            return ue.getPassword().hashCode() == pass.hashCode();
        }
        return false;

    }
}
