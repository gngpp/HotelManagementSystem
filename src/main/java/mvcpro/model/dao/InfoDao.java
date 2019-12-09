package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.Info;

public class InfoDao extends SimpleDaoImpl<Info> {
    public static void main(String[] args) throws Exception {
        InfoDao roomInfoDao=new InfoDao();
        System.out.println(roomInfoDao.list());
    }
}
