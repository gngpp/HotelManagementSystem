package mvcpro.model.utils;

import java.security.MessageDigest;

/**
 * @ClassName MD5Utils
 * @Description TODO
 * @Author zwj
 * @Date 2019-01-15 13:38
 * @Version 1.0
 */
public class MD5 {

    public final static String encrypt(String ss){//MD5加密算法

        try {
            String s = ss == null ? "":ss;//如果为空，则返回""
            char hexDigists[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d',
                    'e','f'};//字典
            byte[] strTemp =s.getBytes();//获取二进制
            MessageDigest mdTemp =MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);//执行加密
            byte[] md = mdTemp.digest();//加密结果
            int j = md.length;//结果长度
            char str[] = new char[j*2];//字符数组
            int k = 0;
            for (int i = 0; i < j; i++) { //将二进制加密结果转化为字符
                byte byte0 = md[i];
                str[k++] = hexDigists[byte0 >>> 4 &0xf];
                str[k++] = hexDigists[byte0 & 0xf];
            }
            return new String(str);//输出加密后的字符
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }
    }
}

