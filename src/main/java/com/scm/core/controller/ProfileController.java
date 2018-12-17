package com.scm.core.controller;

import com.scm.services.dao.impl.UserDaoImpl;
import com.scm.services.model.CargoOwner;
import com.scm.services.util.CargoOwnerServiceUtil;
import com.scm.services.util.UserServiceUtil;
import com.scm.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @GetMapping("cargoOwnerProfile")
    public String cargoOwnerProfile(Model model) {
        logger.info("   Calling cargoOwnerProfile in ProfileController");
        System.out.println("   Calling cargoOwnerProfile in ProfileController");
        model.addAttribute("cargoOwner", new CargoOwner());
        return "cargoOwnerProfile";
    }

    @PostMapping("addCargoOwner")
    public String addCargoOwner(@ModelAttribute("user") CargoOwner cargoOwner, HttpServletRequest request) {
        logger.info("   Calling addCargoOwner in ProfileController");
        System.out.println("   Calling addCargoOwner in ProfileController");
        cargoOwner.setUserByUserId(UserServiceUtil.getUserById(UserUtil.getUserId(request)));
        CargoOwnerServiceUtil.addCargoOwner(cargoOwner);
        return "homePage";
    }
}
