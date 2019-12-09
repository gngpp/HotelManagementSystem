package mvcpro.model.dao;


import com.lqing.orm.internal.SimpleDaoImpl;
import com.lqing.orm.test.Student;
import mvcpro.model.entity.InfoRoom;
import mvcpro.model.entity.Test;
import mvcpro.model.entity.User;

public class InfoRoomDao extends SimpleDaoImpl<InfoRoom> {
    public static void main(String[] args) throws Exception {
        InfoRoomDao roomDao=new InfoRoomDao();
        roomDao.list().forEach(System.out::println);
    }

}
