package com.scm.core.controller.cargoOwner;

import com.scm.services.dao.impl.UserDaoImpl;
import com.scm.services.model.CargoOwner;
import com.scm.services.util.CargoOwnerServiceUtil;
import com.scm.util.Constants;
import com.scm.util.TicketAndCargoAndLocalities;
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
public class CargoOwnerController {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @GetMapping("cargoOwner/profile")
    public String cargoOwnerProfile(Model model, HttpServletRequest request) {
        Constants.showMessageWithIndent("Calling cargoOwnerProfile in CargoOwnerController");
        CargoOwner cargoOwner = CargoOwnerServiceUtil.getCargoOwnerByUserId(UserUtil.getUserId(request));
        if (cargoOwner == null) {
            cargoOwner = new CargoOwner();
        }
        model.addAttribute("cargoOwner", cargoOwner);
        return "cargoOwnerProfile";
    }

    @PostMapping("addCargoOwner")
    public String addCargoOwner(@ModelAttribute("cargoOwner") CargoOwner cargoOwner, HttpServletRequest request) {
        Constants.showMessageWithIndent("Calling addCargoOwner in CargoOwnerController");
        if (cargoOwner.getCargoOwnerId() == null) {
            cargoOwner.setUserId(UserUtil.getUserId(request));
            CargoOwnerServiceUtil.addCargoOwner(cargoOwner);
        } else {
            CargoOwnerServiceUtil.updateCargoOwner(cargoOwner);
        }
        return "redirect:/homePage";
    }

    @GetMapping("cargoOwner/ticketRegistration")
    public String ticketRegistration(Model model) {
        Constants.showMessageWithIndent("Calling ticketRegistration in TicketController");
        model.addAttribute("ticketAndCargoAndMethod", new TicketAndCargoAndLocalities());
        return "ticket";
    }

    @PostMapping("addTicket")
    public String addTicket(@ModelAttribute("ticketAndCargoAndMethod") TicketAndCargoAndLocalities ticketAndCargoAndLocalities,
                            HttpServletRequest request) {
        Constants.showMessageWithIndent("Calling addTicket in TicketController");
        return "redirect:/homePage";
    }
}
