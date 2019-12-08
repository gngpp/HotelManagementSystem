package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.User;

public class UserDao extends SimpleDaoImpl<User>   {
    public static void main(String[] args) throws Exception {
        UserDao userDao=new UserDao();

        User user=new User();
        user.setId("sss");
        user.setPassword("123");
        user.setQuestion_one("问题1");
        user.setQuestion_two("问题2");
        user.setQuestion_three("问题3");
        user.setUserType("用户");
        userDao.save(user);


        userDao.list().forEach(System.out::println);
    }
}
