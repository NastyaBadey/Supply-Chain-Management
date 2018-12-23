package com.scm.services.service.impl;

import com.scm.services.dao.DeliveryMethodDao;
import com.scm.services.model.DeliveryMethod;
import com.scm.services.service.DeliveryMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeliveryMethodServiceImpl implements DeliveryMethodService {

    @Autowired
    private DeliveryMethodDao deliveryMethodDao;

    @Transactional
    public DeliveryMethod addDeliveryMethod(DeliveryMethod deliveryMethod) {
        return deliveryMethodDao.add(deliveryMethod);
    }

    @Transactional
    public void updateDeliveryMethod(DeliveryMethod deliveryMethod) {
        deliveryMethodDao.update(deliveryMethod);
    }

    @Transactional
    public void removeDeliveryMethod(int deliveryMethodId) {
        deliveryMethodDao.remove(deliveryMethodId);
    }

    @Transactional
    public DeliveryMethod getDeliveryMethodById(int deliveryMethodId) {
        return deliveryMethodDao.getById(deliveryMethodId);
    }

    @Transactional
    public List<DeliveryMethod> getAllDeliveryMethods() {
        return deliveryMethodDao.getAll();
    }
}
