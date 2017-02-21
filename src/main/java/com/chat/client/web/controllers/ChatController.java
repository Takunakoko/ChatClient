package com.chat.client.web.controllers;

import com.chat.client.web.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

/**
 * Created by takunaka on 18.02.17.
 */
@Controller
public class ChatController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
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
    public @ResponseBody ModelAndView requestAuth(ModelMap model,
                                                  @RequestParam("login") String loginValue,
                                            @RequestParam("password") String passValue) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        if (usersService.auth(loginValue, passValue))
            return new ModelAndView("redirect:chat", model);
        else
            return new ModelAndView("redirect:index", model);

    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
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
