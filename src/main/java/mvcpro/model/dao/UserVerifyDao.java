package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.UserVerify;

public class UserVerifyDao extends SimpleDaoImpl<UserVerify> {
    public static void main(String [] agrs) throws Exception {
        UserVerifyDao userVerifyDao=new UserVerifyDao();
        userVerifyDao.list().forEach(System.out::println);
    }
}
