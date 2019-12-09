package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.RoomStandard;

public class RoomStandardDao extends SimpleDaoImpl<RoomStandard> {
    public static void main(String[] args) throws Exception {
        RoomStandardDao roomStandardDao=new RoomStandardDao();
        System.out.println(roomStandardDao.list());
    }
}
