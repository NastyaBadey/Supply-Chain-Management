package com.scm.core.controller;

import com.scm.services.dao.impl.UserDaoImpl;
import com.scm.util.Constants;
import com.scm.util.TicketAndCargoAndMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TicketController {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @GetMapping("ticketRegistration")
    public String ticketRegistration(Model model) {
        Constants.showMessage("Calling ticketRegistration in TicketController");
        model.addAttribute("ticketAndCargoAndMethod", new TicketAndCargoAndMethod());
        return "ticket";
    }

    @PostMapping("addTicket")
    public String addTicket(@ModelAttribute("ticketAndCargoAndMethod") TicketAndCargoAndMethod ticketAndCargoAndMethod,
                            HttpServletRequest request) {
        Constants.showMessage("Calling addTicket in TicketController");
        return "homePage";
    }
}
