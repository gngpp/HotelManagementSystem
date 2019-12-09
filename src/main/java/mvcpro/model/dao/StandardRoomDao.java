package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.StandardRoom;

public class StandardRoomDao extends SimpleDaoImpl<StandardRoom> {
    public static void main(String[] args) throws Exception {
        StandardRoomDao roomStandardDao=new StandardRoomDao();
        System.out.println(roomStandardDao.list());
    }
}
