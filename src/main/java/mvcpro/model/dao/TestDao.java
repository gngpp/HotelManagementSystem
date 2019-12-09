package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.Test;

public class TestDao extends SimpleDaoImpl<Test> {

    public static void main(String[] args) throws Exception {
        TestDao testDao=new TestDao();
        System.out.println(testDao.list());
    }
}
