package com.chat.client;

import java.io.*;
import java.util.Scanner;

/**
 * Created by takunaka on 15.02.17.
 */
public class ConsoleReader implements Runnable {
    private PrintWriter pr;

    public ConsoleReader(PrintWriter pr) {
        this.pr = pr;
    }

    public void run() {
            InputStream inStream = new BufferedInputStream(System.in);
            Scanner scan = new Scanner(inStream);



        while (scan.hasNextLine()){
            pr.println(scan.nextLine());
            pr.flush();
        }

    }
}
