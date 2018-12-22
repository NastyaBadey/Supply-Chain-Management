package com.scm.core.controller;

import com.scm.services.dao.impl.CargoDaoImpl;
import com.scm.services.model.Cargo;
import com.scm.services.util.CargoServiceUtil;
import com.scm.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CargoController {
    private static final Logger logger = LoggerFactory.getLogger(CargoDaoImpl.class);

    @RequestMapping(value = "/cargo/add", method = RequestMethod.POST)
    public String addCargo(@ModelAttribute("cargo") Cargo cargo) {
        Constants.showMessageWithIndent("Calling addCargo in CargoController");
        if (cargo.getCargoId() == null) {
            CargoServiceUtil.addCargo(cargo);
        } else {
            CargoServiceUtil.updateCargo(cargo);
        }
        return "redirect:/cargoes";
    }

    @RequestMapping(value = "/cargo/edit/{id}", method = RequestMethod.POST)
    public String editCargo(@PathVariable("id") int cargoId, Model model) {
        Constants.showMessageWithIndent("Calling editCargo in CargoController");
        model.addAttribute("cargo", CargoServiceUtil.getCargoById(cargoId));
        model.addAttribute("cargoList", CargoServiceUtil.getAllCargoes());
        return "cargoes";
    }

    @RequestMapping("/cargo/remove/{id}")
    public String removeCargo(@PathVariable("id") int cargoId) {
        Constants.showMessageWithIndent("Calling removeCargo in CargoController");
        CargoServiceUtil.removeCargo(cargoId);
        return "redirect:/cargoes";
    }

    @RequestMapping("cargoInfo/{id}")
    public String gerCargoInfo(@PathVariable("id") int cargoId, Model model) {
        Constants.showMessageWithIndent("Calling gerCargoInfo in CargoController");
        model.addAttribute("cargo", CargoServiceUtil.getCargoById(cargoId));
        return "cargoInfo";
    }

    @RequestMapping(value = "cargoes", method = RequestMethod.GET)
    public String getCargoList(Model model) {
        Constants.showMessageWithIndent("Calling getCargoList in CargoController");
        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargoList", CargoServiceUtil.getAllCargoes());
        return "cargoes";
    }
}
