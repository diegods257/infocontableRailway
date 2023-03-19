package com.infocontable.infocontable.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PortalController {

    @GetMapping(value = {"/login","/"})
    public String login(){
        return "login";
    }

}
