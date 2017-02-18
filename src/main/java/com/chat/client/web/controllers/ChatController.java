package com.chat.client.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

/**
 * Created by takunaka on 18.02.17.
 */
@Controller
public class ChatController {

    @RequestMapping(value = "/index.html", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public @ResponseBody String showAuthForm() {
        File htmlFile = new File("/Users/takunaka/Downloads/index.html");
        BufferedReader bfr = null;
        Reader rd;
        String line = "";

        try {
            bfr = new BufferedReader(new FileReader(htmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while (bfr.ready()){
               line += bfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
