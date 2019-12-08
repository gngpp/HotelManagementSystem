package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.UserVerify;

public class UserVerifyDao extends SimpleDaoImpl<UserVerify> {
    public static void main(String[] args) throws Exception {
        UserVerifyDao testVerify=new UserVerifyDao();

        UserVerify userVerify=new UserVerify();
        userVerify.setSelect_one("1");
        userVerify.setSelect_two("2");
        userVerify.setSelect_three("3");

        testVerify.save(userVerify);
        testVerify.list().forEach(System.out::println);

    }
}
