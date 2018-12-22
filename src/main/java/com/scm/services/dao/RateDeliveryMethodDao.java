package com.scm.services.dao;

import com.scm.services.model.RateDeliveryMethod;

public interface RateDeliveryMethodDao extends Dao<RateDeliveryMethod> {
    RateDeliveryMethod getRateDeliveryMethodByRateId(int rateId);
}
