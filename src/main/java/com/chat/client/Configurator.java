package com.chat.client;

/**
 * Created by takunaka on 15.02.17.
 */
public class Configurator {
    private Configurator() {

    }

    private static String host = "localhost";
    private static int port = 8080;

    private static String dbHost = "localhost";
    private static String dbPort = "3306";
    private static String username = "root";
    private static String password = "root";


    public static String getDbHost() {
        return dbHost;
    }

    public static String getDbPort() {
        return dbPort;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getHost() {
        return host;
    }

    public static int getPort() {
        return port;
    }

}
