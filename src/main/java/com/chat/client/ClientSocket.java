package com.chat.client;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by takunaka on 15.02.17.
 */
public class ClientSocket {

    private ClientSocket() {

    }
    public static Socket createClientSocket(String host, int port) throws IOException {
        return new Socket(host, port);
    }
}
