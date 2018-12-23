package com.scm.util;

import com.scm.services.model.Carrier;
import com.scm.services.model.User;
import com.scm.services.util.CarrierServiceUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtil {
    public static void addUser(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute(Constants.CURRENT_USER_ID, user.getUserId());
        session.setAttribute(Constants.CURRENT_USER_LOGIN, user.getUserLogin());
        session.setAttribute(Constants.CURRENT_USER_ROLE, user.getUserRole());
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

    public static void removeUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.CURRENT_USER_ID);
        session.removeAttribute(Constants.CURRENT_USER_LOGIN);
        session.removeAttribute(Constants.CURRENT_USER_ROLE);
    }

    public static Integer getRoleId(HttpServletRequest request) {
        Carrier carrier = CarrierServiceUtil.getCarrierByUserId(getUserId(request));
        if (carrier != null) {
            return carrier.getCarrierId();
        }
        return null;
    }
}
