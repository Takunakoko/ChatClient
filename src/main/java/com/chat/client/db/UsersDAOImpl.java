package com.chat.client.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by takunaka on 17.02.17.
 */
@Component
public class UsersDAOImpl implements UsersDAO{


    public UsersEntity getUser(String login) throws SQLException {
        Configuration config = null;
        try {
            config = HibernateConfigurator.getConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<UsersEntity> list = session.createQuery("from UsersEntity", UsersEntity.class).list();

        for (UsersEntity ue : list){
            if(login.equals(ue.getUsername())){
                return ue;
            }
        }
        return null;
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
