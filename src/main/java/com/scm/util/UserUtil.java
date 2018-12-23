package com.scm.util;

import com.scm.services.model.CargoOwner;
import com.scm.services.model.Carrier;
import com.scm.services.model.User;
import com.scm.services.util.CargoOwnerServiceUtil;
import com.scm.services.util.CarrierServiceUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtil {
    public static void addUser(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute(Constants.CURRENT_USER_ID, user.getUserId());
        session.setAttribute(Constants.CURRENT_USER_LOGIN, user.getUserLogin());
        session.setAttribute(Constants.CURRENT_USER_ROLE, user.getUserRole());

        boolean profileExists = false;
        Carrier carrier = CarrierServiceUtil.getCarrierByUserId(user.getUserId());
        Integer carrierId = null;
        CargoOwner cargoOwner = CargoOwnerServiceUtil.getCargoOwnerByUserId(user.getUserId());
        Integer cargoOwnerId = null;
        if (carrier != null) {
            profileExists = true;
            carrierId = carrier.getCarrierId();
        } else if (cargoOwner != null) {
            profileExists = true;
            cargoOwnerId = cargoOwner.getCargoOwnerId();
        }
        session.setAttribute(Constants.PROFILE_EXISTS, profileExists);
        session.setAttribute(Constants.CARRIER_ID, carrierId);
        session.setAttribute(Constants.CARGO_OWNER_ID, cargoOwnerId);
    }

    public static Integer getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Integer) session.getAttribute(Constants.CURRENT_USER_ID);
    }

    public static String getUserLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute(Constants.CURRENT_USER_LOGIN);
    }

    public static String getUserRole(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute(Constants.CURRENT_USER_ROLE);
    }

    public static boolean isProfileExists(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Boolean) session.getAttribute(Constants.PROFILE_EXISTS);
    }

    public static Integer getCarrierId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Integer) session.getAttribute(Constants.CARRIER_ID);
    }

    public static Integer getCargoOwnerId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Integer) session.getAttribute(Constants.CARGO_OWNER_ID);
    }

    public static void removeUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.CURRENT_USER_ID);
        session.removeAttribute(Constants.CURRENT_USER_LOGIN);
        session.removeAttribute(Constants.CURRENT_USER_ROLE);
        session.removeAttribute(Constants.PROFILE_EXISTS);
        session.removeAttribute(Constants.CARRIER_ID);
        session.removeAttribute(Constants.CARGO_OWNER_ID);
    }
}
