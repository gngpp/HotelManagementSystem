package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.UserVerify;

public class UserVerifyDao extends SimpleDaoImpl<UserVerify> {
    public static void main(String[] args) throws Exception {
        UserVerifyDao testVerify=new UserVerifyDao();

        UserVerify userVerify=new UserVerify();

        testVerify.list().forEach(System.out::println);

    }
}
