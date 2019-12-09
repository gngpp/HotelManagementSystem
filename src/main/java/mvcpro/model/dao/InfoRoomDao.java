package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.InfoRoom;

public class InfoRoomDao extends SimpleDaoImpl<InfoRoom> {
    public static void main(String[] args) throws Exception {
        InfoRoomDao roomDao=new InfoRoomDao();
        System.out.println(roomDao.list());
    }

}
