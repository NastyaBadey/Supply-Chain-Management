package com.scm.util;

public class Constants {
    public static final String CURRENT_USER_ID = "currentUserId";
    public static final String CURRENT_USER_LOGIN = "currentUserLogin";

    public static void showMessage(String message){
        System.out.println("   " + message);
    }

    /*public static void showMessage(Class loggerClass, String message){
        final Logger logger = LoggerFactory.getLogger(loggerClass);
        System.out.println(message);
    }*/
}
