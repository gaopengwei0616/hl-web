package com.yida.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController  {


    @RequestMapping("/login")
    public String login(){
        return "Login";
    }

    /*@RequestMapping("/logout")
    public String logout(){
        return "Login";
    }*/


}
