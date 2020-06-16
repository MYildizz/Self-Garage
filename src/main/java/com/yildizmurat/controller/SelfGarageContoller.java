package com.yildizmurat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SelfGarageContoller {


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){

        return "index";
    }

    @RequestMapping(value="/driverLogin", method = RequestMethod.GET)
    public String driverLogin(){

        return "driverLogin";
    }
    
    @RequestMapping(value="/ownerLogin", method = RequestMethod.GET)
    public String ownerLogin(){

        return "ownerLogin";
    }
    
    @RequestMapping(value="/driverSignUp", method = RequestMethod.GET)
    public String driverSignUp(){

        return "driverSignUp";
    }
    
    @RequestMapping(value="/ownerSignUp", method = RequestMethod.GET)
    public String ownerSignUp(){

        return "ownerSignUp";
    }

}
