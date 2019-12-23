package mvcpro.model.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uitls {

    public static boolean isNumber(String phone) {
        String regex = "^[0-9]*$";
        return phone.matches(regex);
    }
    public static boolean isPhone(String str) {
        Pattern p1 = null, p2 = null;
        Matcher m = null;
        boolean isPhone = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            isPhone = m.matches();
        } else {
            m = p2.matcher(str);
            isPhone = m.matches();
        }
        return isPhone;
    }

    public static void main(String[] args) {

        String phone = "0770-88889999";
        if(isPhone(phone)){
            System.out.println(phone+"是符合的电话号码");
        }else {
            System.out.println(phone+"不符合");
        }
    }

}
