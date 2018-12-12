package com.scm.util;

import com.scm.services.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtil {
    public static void addUser(HttpServletRequest request, User user){
        HttpSession session = request.getSession();
        session.setAttribute(Constants.CURRENT_USER_ID, user.getUserId());
        session.setAttribute(Constants.CURRENT_USER_LOGIN, user.getUserLogin());
    }

    public static Integer getUserId(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (Integer) session.getAttribute(Constants.CURRENT_USER_ID);
    }

    public static String getUserLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (String) session.getAttribute(Constants.CURRENT_USER_LOGIN);
    }

    public static void removeUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.CURRENT_USER_ID);
        session.removeAttribute(Constants.CURRENT_USER_LOGIN);
    }
}
