package com.scm.util;

import com.scm.services.model.Carrier;
import com.scm.services.model.DeliveryMethod;
import com.scm.services.model.Rate;
import com.scm.services.util.DeliveryMethodServiceUtil;
import com.scm.services.util.RateDeliveryMethodServiceUtil;
import com.scm.services.util.RateServiceUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CarrierAndRatesAndDeliveryMethods {
    Carrier carrier;
    DeliveryMethod selectedDeliveryMethod;
    List<DeliveryMethod> deliveryMethods;
    Rate rate;
    List<Rate> rates;
    List<DeliveryMethod> deliveryMethodsByRates; //for table

    public CarrierAndRatesAndDeliveryMethods(HttpServletRequest request) {
        this.carrier = new Carrier();
        this.selectedDeliveryMethod = new DeliveryMethod();
        this.deliveryMethods = DeliveryMethodServiceUtil.getAllDeliveryMethods();
        this.rate = new Rate();
        Integer roleId = UserUtil.getRoleId(request);
        if (roleId != null){
            this.rates = RateServiceUtil.getAllRatesByCarrierId(roleId);
        } else {
            this.rates = new ArrayList<Rate>();
        }
        this.deliveryMethodsByRates = new ArrayList<DeliveryMethod>();
        for (Rate currentRate : this.rates){
            DeliveryMethod currentDeliveryMethod = DeliveryMethodServiceUtil.getDeliveryMethodById(
                    RateDeliveryMethodServiceUtil.getRateDeliveryMethodByRateId(currentRate.getRateId())
                            .getDeliveryMethodId());
            this.deliveryMethodsByRates.add(currentDeliveryMethod);
            this.deliveryMethods.remove(currentDeliveryMethod);
        }
    }

    public CarrierAndRatesAndDeliveryMethods(Carrier carrier, List<Rate> rates, List<DeliveryMethod> deliveryMethods) {
        this.carrier = carrier;
        this.rates = rates;
        this.deliveryMethods = deliveryMethods;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setDeliveryMethods(List<DeliveryMethod> deliveryMethods) {
        this.deliveryMethods = deliveryMethods;
    }

    public List<DeliveryMethod> getDeliveryMethods() {
        return deliveryMethods;
    }

    public void setSelectedDeliveryMethod(DeliveryMethod selectedDeliveryMethod) {
        this.selectedDeliveryMethod = selectedDeliveryMethod;
    }

    public DeliveryMethod getSelectedDeliveryMethod() {
        return selectedDeliveryMethod;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Rate getRate() {
        return rate;
    }

    public void setDeliveryMethodsByRates(List<DeliveryMethod> deliveryMethodsByRates) {
        this.deliveryMethodsByRates = deliveryMethodsByRates;
    }

    public List<DeliveryMethod> getDeliveryMethodsByRates() {
        return deliveryMethodsByRates;
    }

    @Override
    public String toString() {
        return "CarrierAndRatesAndDeliveryMethods{" +
                "carrier=" + carrier +
                ", selectedDeliveryMethod=" + selectedDeliveryMethod +
                ", deliveryMethods=" + deliveryMethods +
                ", rate=" + rate +
                ", rates=" + rates +
                ", deliveryMethodsByRates=" + deliveryMethodsByRates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarrierAndRatesAndDeliveryMethods that = (CarrierAndRatesAndDeliveryMethods) o;

        if (carrier != null ? !carrier.equals(that.carrier) : that.carrier != null) return false;
        if (selectedDeliveryMethod != null ? !selectedDeliveryMethod.equals(that.selectedDeliveryMethod) : that.selectedDeliveryMethod != null)
            return false;
        if (deliveryMethods != null ? !deliveryMethods.equals(that.deliveryMethods) : that.deliveryMethods != null)
            return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (rates != null ? !rates.equals(that.rates) : that.rates != null) return false;
        return deliveryMethodsByRates != null ? deliveryMethodsByRates.equals(that.deliveryMethodsByRates) : that.deliveryMethodsByRates == null;
    }

    @Override
    public int hashCode() {
        int result = carrier != null ? carrier.hashCode() : 0;
        result = 31 * result + (selectedDeliveryMethod != null ? selectedDeliveryMethod.hashCode() : 0);
        result = 31 * result + (deliveryMethods != null ? deliveryMethods.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (rates != null ? rates.hashCode() : 0);
        result = 31 * result + (deliveryMethodsByRates != null ? deliveryMethodsByRates.hashCode() : 0);
        return result;
    }
}
