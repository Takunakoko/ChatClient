package com.chat.client.db;

import org.apache.commons.io.IOUtils;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by takunaka on 01.03.17.
 */
public class HibernateConfigurator {

    public static Configuration getConfig() throws IOException {

        return new Configuration().configure(new File(HibernateConfigurator.class.
                getResource("/hibernate.cfg.xml").getFile()));
    }
}
