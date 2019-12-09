package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.User;

public class UserDao extends SimpleDaoImpl<User>   {
    public static void main(String[] args) throws Exception {
        UserDao userDao=new UserDao();

        userDao.list().forEach(System.out::println);
    }
}
