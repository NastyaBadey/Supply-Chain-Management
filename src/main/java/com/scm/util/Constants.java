package com.scm.util;

public class Constants {
    public static final String CURRENT_USER_ID = "currentUserId";
    public static final String CURRENT_USER_LOGIN = "currentUserLogin";
    public static final String CURRENT_USER_ROLE = "currentUserLoginRole";

    public static void showMessage(String message) {
        System.out.println("   " + message);
    }

    public static void showMessageWithIndent(String message) {
        System.out.println("   " + message);
    }

    public static void showErrorMessage(String message) {
        System.out.println("ERROR:\n " + message);
    }

    /*public static void showMessageWithIndent(Class loggerClass, String message){
        final Logger logger = LoggerFactory.getLogger(loggerClass);
        System.out.println(message);
    }*/
}
