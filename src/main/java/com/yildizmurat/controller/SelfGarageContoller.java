package com.yildizmurat.controller;


import com.yildizmurat.service.implementation.DriverInformationImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String adminSignUp(){

        return "adminLogin";
    }

    @RequestMapping(value="/driverPage", method = RequestMethod.GET)
    public String driverPage(Model model, HttpServletRequest req ){

        model.addAttribute("driverId",req.getSession().getAttribute("driverId"));

        return "driverPage";
    }

    @RequestMapping(value="/driverUsages", method = RequestMethod.GET)
    public String driverUsages(){

        return "driverUsages";
    }

    @RequestMapping(value="/driverCreditCard", method = RequestMethod.GET)
    public String driverCreditCard(){

        return "driverCreditCard";
    }

    @RequestMapping(value="/driverSettings", method = RequestMethod.GET)
    public String driverSettings(){

        return "driverSettings";
    }

    @RequestMapping(value="/ownerPage", method = RequestMethod.GET)
    public String ownerPage(Model model, HttpServletRequest req ){

        model.addAttribute("ownerId",req.getSession().getAttribute("ownerId"));
        return "ownerPage";
    }

}
