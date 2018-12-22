package com.scm.core.controller;

import com.scm.services.dao.impl.UserDaoImpl;
import com.scm.services.model.CargoOwner;
import com.scm.services.model.Locality;
import com.scm.services.util.CargoOwnerServiceUtil;
import com.scm.util.Constants;
import com.scm.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

public class LocalityController {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @GetMapping("locality")
    public String cargoOwnerProfile(Model model) {
        Constants.showMessage("Calling locality in LocalityController");
        model.addAttribute("locality", new Locality());
        return "locality";
    }

    @PostMapping("addLocality")
    public String addLocality(@ModelAttribute("locality") Locality locality, HttpServletRequest request) {
        Constants.showMessage("Calling addCargoOwner in ProfileController");
        return "homePage";
    }
}
