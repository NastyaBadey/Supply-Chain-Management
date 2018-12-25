package com.scm.core.controller.carrier;

import com.scm.services.model.DeliveryMethod;
import com.scm.services.model.Rate;
import com.scm.services.util.DeliveryMethodServiceUtil;
import com.scm.services.util.RateServiceUtil;
import com.scm.util.Constants;
import com.scm.util.RatesAndDeliveryMethods;
import com.scm.util.UserUtil;
import org.json.JSONArray;
import org.json.JSONObject;
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
public class RateController {

    @GetMapping("carrier/rates")
    public String rates(Model model, HttpServletRequest request) {
        Constants.showMessageWithIndent("Calling rates in CarrierController");
        List<DeliveryMethod> deliveryMethods = DeliveryMethodServiceUtil.getAllDeliveryMethods();
        List<Rate> rates = RateServiceUtil.getAllRatesByCarrierId(UserUtil.getCarrierId(request));
        for (Rate currentRate : rates) {
            DeliveryMethod currentDeliveryMethod = DeliveryMethodServiceUtil
                    .getDeliveryMethodById(currentRate.getDeliveryMethodId());
            deliveryMethods.remove(currentDeliveryMethod);
        }
        RatesAndDeliveryMethods ratesAndDeliveryMethods = new RatesAndDeliveryMethods(new Rate(),
                null, deliveryMethods);

        ratesAndDeliveryMethods.setDeliveryMethods(deliveryMethods);
        model.addAttribute("ratesAndDeliveryMethods", ratesAndDeliveryMethods);
        return "rates";
    }

    @GetMapping("getRates")
    public void getRates(HttpServletRequest request, HttpServletResponse response) {
        Constants.showMessageWithIndent("Calling getRates in CarrierController");
        response.setContentType("application/json");
        try {
            response.getWriter().write(makeRateJSON(request).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONArray makeRateJSON(HttpServletRequest request) {
        List<Rate> rates = RateServiceUtil.getAllRatesByCarrierId(UserUtil.getCarrierId(request));
        List<DeliveryMethod> deliveryMethodsByRates = new ArrayList<DeliveryMethod>();
        for (Rate currentRate : rates) {
            DeliveryMethod currentDeliveryMethod = DeliveryMethodServiceUtil
                    .getDeliveryMethodById(currentRate.getDeliveryMethodId());
            deliveryMethodsByRates.add(currentDeliveryMethod);
        }
        JSONArray ratesJson = new JSONArray();
        for (int i = 0; i < rates.size(); i++) {
            JSONObject rateJson = new JSONObject();
            rateJson.put("rateId", rates.get(i).getRateId());
            rateJson.put("deliveryMethod", deliveryMethodsByRates.get(i).getDeliveryMethodName());
            rateJson.put("ratePrice", rates.get(i).getRatePricePerKg());
            rateJson.put("averageSpeed", rates.get(i).getAverageSpeed());
            ratesJson.put(rateJson);
        }
        return ratesJson;
    }

    @PostMapping("addRate")
    public String addRate(@ModelAttribute("ratesAndDeliveryMethods")
                                  RatesAndDeliveryMethods ratesAndDeliveryMethods, HttpServletRequest request) {
        Constants.showMessageWithIndent("Calling addRate in CarrierController");
        Integer deliveryMethodId = ratesAndDeliveryMethods.getSelectedDeliveryMethodId();
        Rate rate = ratesAndDeliveryMethods.getRate();
        rate.setCarrierId(UserUtil.getCarrierId(request));
        rate.setDeliveryMethodId(deliveryMethodId);
        if (rate.getRateId() == null) {
            RateServiceUtil.addRate(rate);
        } else {
            RateServiceUtil.updateRate(rate);
        }

        return "redirect:/carrier/rates";
    }

    @GetMapping("carrier/editRate/{rateId}")
    public String editRate(@PathVariable("rateId") int rateId, Model model, HttpServletRequest request) {
        Constants.showMessageWithIndent("Calling editRate in CarrierController");
        Rate rate = RateServiceUtil.getRateById(rateId);
        Integer selectedDeliveryMethodId = rate.getDeliveryMethodId();
        List<DeliveryMethod> deliveryMethods = DeliveryMethodServiceUtil.getAllDeliveryMethods();
        List<Rate> rates = RateServiceUtil.getAllRatesByCarrierId(UserUtil.getCarrierId(request));
        for (Rate currentRate : rates) {
            DeliveryMethod currentDeliveryMethod = DeliveryMethodServiceUtil
                    .getDeliveryMethodById(currentRate.getDeliveryMethodId());
            if (currentDeliveryMethod.getDeliveryMethodId() != selectedDeliveryMethodId) {
                deliveryMethods.remove(currentDeliveryMethod);
            }
        }

        RatesAndDeliveryMethods ratesAndDeliveryMethods = new RatesAndDeliveryMethods(rate,
                selectedDeliveryMethodId, deliveryMethods);
        model.addAttribute("ratesAndDeliveryMethods", ratesAndDeliveryMethods);
        return "rates";
    }

    @GetMapping("carrier/removeRate/{rateId}")
    public String removeRate(@PathVariable("rateId") int rateId) {
        Constants.showMessageWithIndent("Calling removeRate in CarrierController");
        RateServiceUtil.removeRate(rateId);
        return "redirect:/carrier/rates";
    }
}
