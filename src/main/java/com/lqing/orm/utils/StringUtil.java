package com.lqing.orm.utils;

public class StringUtil {
    public static String toFirstCharUpperCase(String arg){
        return arg.substring(0, 1).toUpperCase() + arg.substring(1);
    }

    public static String toFirstCharLowerCase(String arg){
        return arg.substring(0, 1).toLowerCase() + arg.substring(1);
    }
}
