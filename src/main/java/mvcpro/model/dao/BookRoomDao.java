package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.BookRoom;
import mvcpro.model.entity.Client;

public class BookRoomDao extends SimpleDaoImpl<BookRoom> {
    public static void main(String[] args) throws Exception {
        BookRoomDao bookRoomDao=new BookRoomDao();
        System.out.println(bookRoomDao.list());
    }
}
