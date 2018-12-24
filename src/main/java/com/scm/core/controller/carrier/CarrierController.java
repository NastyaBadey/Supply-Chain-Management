package com.scm.core.controller.carrier;

import com.scm.services.dao.impl.UserDaoImpl;
import com.scm.services.model.Carrier;
import com.scm.services.model.DeliveryMethod;
import com.scm.services.model.Rate;
import com.scm.services.util.CarrierServiceUtil;
import com.scm.services.util.DeliveryMethodServiceUtil;
import com.scm.services.util.RateServiceUtil;
import com.scm.util.Constants;
import com.scm.util.RatesAndDeliveryMethods;
import com.scm.util.UserUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarrierController {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @GetMapping("carrier/profile")
    public String carrierProfile(Model model, HttpServletRequest request) {
        Constants.showMessageWithIndent("Calling carrierProfile in CarrierController");
        Carrier carrier = CarrierServiceUtil.getCarrierByUserId(UserUtil.getUserId(request));
        if (carrier == null) {
            carrier = new Carrier();
        }
        model.addAttribute("carrier", carrier);
        return "carrierProfile";
    }

    @PostMapping("addCarrier")
    public String addCarrier(@ModelAttribute("carrier") Carrier carrier, HttpServletRequest request) {
        Constants.showMessageWithIndent("Calling addCarrier in CarrierController");
        if (carrier.getCarrierId() == null) {
            carrier.setUserId(UserUtil.getUserId(request));
            CarrierServiceUtil.addCarrier(carrier);
        } else {
            CarrierServiceUtil.updateCarrier(carrier);
        }
        return "redirect:/homePage";
    }

}
