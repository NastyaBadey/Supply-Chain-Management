package com.scm.core.controller;

import com.scm.services.dao.impl.UserDaoImpl;
import com.scm.services.model.CargoOwner;
import com.scm.services.model.DeliveryMethod;
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

public class DeliveryMethodController {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @GetMapping("deliveryMethod")
    public String cargoOwnerProfile(Model model) {
        Constants.showMessage("Calling deliveryMethod in DeliveryMethodController");
        model.addAttribute("deliveryMethod", new DeliveryMethod());
        return "deliveryMethod";
    }

    @PostMapping("addDeliveryMethod")
    public String addCargoOwner(@ModelAttribute("deliveryMethod") DeliveryMethod deliveryMethod, HttpServletRequest request) {
        Constants.showMessage("Calling addDeliveryMethod in DeliveryMethodController");
        return "homePage";
    }
}
