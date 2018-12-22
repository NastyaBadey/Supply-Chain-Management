package com.scm.core.controller;

import com.scm.services.dao.impl.UserDaoImpl;
import com.scm.services.model.Carrier;
import com.scm.services.util.CarrierServiceUtil;
import com.scm.util.CarrierAndRatesAndDeliveryMethods;
import com.scm.util.Constants;
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
public class CarrierController {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @GetMapping("carrierProfile")
    public String carrierProfile(Model model, HttpServletRequest request) {
        Constants.showMessage("Calling carrierProfile in CarrierController");
        model.addAttribute("carrierAndRatesAndDeliveryMethods", new CarrierAndRatesAndDeliveryMethods(request));
        return "carrierProfile";
    }

    @PostMapping("addCarrier")
    public String addCarrier(@ModelAttribute("carrierAndRatesAndDeliveryMethods")
                                         CarrierAndRatesAndDeliveryMethods carrierAndRatesAndDeliveryMethods,
                             HttpServletRequest request) {
        Constants.showMessage("Calling addCarrier in CarrierController");
        /*carrier.setUserId(UserUtil.getUserId(request));
        CarrierServiceUtil.addCarrier(carrier);*/
        return "redirect:homePage";
    }
}
