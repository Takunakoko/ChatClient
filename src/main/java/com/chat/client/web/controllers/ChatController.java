package com.chat.client.web.controllers;

import com.chat.client.web.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import java.io.*;

/**
 * Created by takunaka on 18.02.17.
 */
@Controller
public class ChatController {
    @Autowired
    private UsersService usersService;

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
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;

    }



    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
    @ResponseBody
    public String requestAuth(@RequestParam("login") String loginValue,
                     @RequestParam("password") String passValue) {

         if (usersService.auth(loginValue, passValue))
             return "<head><!— HTML meta refresh URL redirection —><meta http-equiv=\"refresh\" " +
                     "content=\"0; url=/clientchat/chat.html\"></head><body></body>";
         else
             return "<head><!— HTML meta refresh URL redirection —><meta http-equiv=\"refresh\" " +
                     "content=\"0; url=/clientchat/index.html\"></head><body></body>";
    }

    @RequestMapping(value = "/chat.html", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public @ResponseBody String showChatWindow() {
        File htmlFile = new File("/Users/takunaka/Downloads/chat.html");
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
