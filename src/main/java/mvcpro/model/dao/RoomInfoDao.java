package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.RoomInfo;
import mvcpro.model.entity.User;

public class RoomInfoDao extends SimpleDaoImpl<RoomInfo> {
    public static void main(String[] args) throws Exception {
      RoomInfoDao roomInfoDao=new RoomInfoDao();
        System.out.println(roomInfoDao.list());
    }
}
