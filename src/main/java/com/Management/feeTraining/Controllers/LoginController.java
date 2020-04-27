package com.Management.feeTraining.Controllers;

import com.Management.feeTraining.Entities.User;
import com.Management.feeTraining.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("log")
public class LoginController {


    @Autowired
    public LoginService loginService;

    @PostMapping("/signin")
    public String authUser(@RequestParam long id, @RequestParam String password, HttpSession session){
        User user=loginService.authUser(id, password);
        if (user==null)
            return "giremedin";

        session.setAttribute("loggedInUser", user);
        return "girdinn";
    }

    @GetMapping("/signout")
    public String logOut(HttpSession session){
        session.removeAttribute("loggedInUser");

        return "home";     //login.html
    }




}
