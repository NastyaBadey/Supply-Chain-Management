package com.scm.core.controller;

import com.scm.services.dao.impl.UserDaoImpl;
import com.scm.services.model.User;
import com.scm.services.util.UserServiceUtil;
import com.scm.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public String signUp(Model model) {
        logger.info("   Calling signUp in UserController");
        System.out.println("   Calling signUp in UserController");
        model.addAttribute("user", new User());
        return "signUp";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, HttpServletRequest request) {
        logger.info("   Calling register in UserController");
        System.out.println("   Calling register in UserController");
        if (user.getUserId() == null) {
            UserServiceUtil.addUser(user);
        } else {
            UserServiceUtil.updateUser(user);
        }
        UserUtil.addUser(request, user);
        return "homePage";
    }

    //то же самое, что и @RequestMapping(value = "signIn", method = RequestMethod.GET)
    @GetMapping("signIn")
    public String signIn(Model model) {
        logger.info("   Calling signIn in UserController");
        System.out.println("   Calling signIn in UserController");
        model.addAttribute("user", new User());
        return "signIn";
    }

    //то же самое, что и @RequestMapping(value = "login", method = RequestMethod.POST)
    @PostMapping("login")
    public String login(@ModelAttribute("user") User user, HttpServletRequest request) {
        logger.info("   Calling login in UserController");
        System.out.println("   Calling login in UserController");
        User currentUser = UserServiceUtil.getUserByLoginAndPassword(user);
        if (currentUser != null) {
            UserUtil.addUser(request, currentUser);
        }
        return "homePage";
    }


    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        logger.info("   Calling logout in UserController");
        System.out.println("   Calling logout in UserController");
        UserUtil.removeUser(request);
        return "homePage";
    }
}
