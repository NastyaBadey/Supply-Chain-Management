package com.scm.util;

import com.scm.services.model.DeliveryMethod;
import com.scm.services.model.Rate;
import com.scm.services.util.DeliveryMethodServiceUtil;
import com.scm.services.util.RateServiceUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RatesAndDeliveryMethods {
    Integer selectedDeliveryMethodId;
    List<DeliveryMethod> deliveryMethods; //для выпадающего списка
    Rate rate;

    public RatesAndDeliveryMethods() {
        this.selectedDeliveryMethodId = null;
        this.deliveryMethods = new ArrayList<DeliveryMethod>();
        this.rate = new Rate();
    }

    public RatesAndDeliveryMethods(HttpServletRequest request) {
        this.rate = new Rate();
        this.selectedDeliveryMethodId = null;
        this.deliveryMethods = DeliveryMethodServiceUtil.getAllDeliveryMethods();
        List<Rate> rates = RateServiceUtil.getAllRatesByCarrierId(UserUtil.getCarrierId(request));
        for (Rate currentRate : rates) {
            DeliveryMethod currentDeliveryMethod = DeliveryMethodServiceUtil
                    .getDeliveryMethodById(currentRate.getDeliveryMethodId());
            this.deliveryMethods.remove(currentDeliveryMethod);
        }
    }

    public RatesAndDeliveryMethods(int rateId, HttpServletRequest request) {
        this.rate = RateServiceUtil.getRateById(rateId);
        this.selectedDeliveryMethodId = this.rate.getDeliveryMethodId();
        this.deliveryMethods = DeliveryMethodServiceUtil.getAllDeliveryMethods();
        List<Rate> rates = RateServiceUtil.getAllRatesByCarrierId(UserUtil.getCarrierId(request));
        for (Rate currentRate : rates) {
            DeliveryMethod currentDeliveryMethod = DeliveryMethodServiceUtil
                    .getDeliveryMethodById(currentRate.getDeliveryMethodId());
            if (currentDeliveryMethod.getDeliveryMethodId() != selectedDeliveryMethodId) {
                this.deliveryMethods.remove(currentDeliveryMethod);
            }
        }
    }

    public Integer getSelectedDeliveryMethodId() {
        return selectedDeliveryMethodId;
    }

    public void setSelectedDeliveryMethodId(Integer selectedDeliveryMethodId) {
        this.selectedDeliveryMethodId = selectedDeliveryMethodId;
    }

    public List<DeliveryMethod> getDeliveryMethods() {
        return deliveryMethods;
    }

    public void setDeliveryMethods(List<DeliveryMethod> deliveryMethods) {
        this.deliveryMethods = deliveryMethods;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "RatesAndDeliveryMethods{" +
                "selectedDeliveryMethodId=" + selectedDeliveryMethodId +
                ", deliveryMethods=" + deliveryMethods +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatesAndDeliveryMethods that = (RatesAndDeliveryMethods) o;

        if (selectedDeliveryMethodId != null ? !selectedDeliveryMethodId.equals(that.selectedDeliveryMethodId) : that.selectedDeliveryMethodId != null)
            return false;
        if (deliveryMethods != null ? !deliveryMethods.equals(that.deliveryMethods) : that.deliveryMethods != null)
            return false;
        return rate != null ? rate.equals(that.rate) : that.rate == null;
    }

    @Override
    public int hashCode() {
        int result = selectedDeliveryMethodId != null ? selectedDeliveryMethodId.hashCode() : 0;
        result = 31 * result + (deliveryMethods != null ? deliveryMethods.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }
}
