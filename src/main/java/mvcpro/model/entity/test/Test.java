package mvcpro.model.entity.test;

import com.lqing.orm.internal.SimpleDaoImpl;
import com.lqing.orm.internal.connection.C3p0ConnectionProvider;
import mvcpro.model.dao.InfoRoomDao;
import mvcpro.model.entity.InfoRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        try {

            C3p0ConnectionProvider c3p0ConnectionProvider=new C3p0ConnectionProvider();
            try(Connection conn=c3p0ConnectionProvider.getConnection()){
                PreparedStatement pst = conn.prepareStatement("select * from users");
                ResultSet st=pst.executeQuery();
                while (st.next()){
                    System.out.println(st.getString(2));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        //    Connection connection=DriverManager.getConnection("数据库的url","root","你的数据库密码");
//          // System.out.println(connection);
     //       StudentDao student=new StudentDao();
            //获取所有对象的字段信息
     //       System.out.println(student.list());
//            student.list().forEach(System.out::println);
//            //分行遍历所有对象字段信息
//            student.list().forEach(System.out::println);
//            for(int i=0;i<10;i++){
//                InfoRoom test=new InfoRoom();
//                test.setName("hanbi");
//                student.save(test);
//            }
//            //根据id查询
//            System.out.println(student.load(5).getName());
//
//            //获取表信息
//            System.out.println(student.info());
//
//            //根据id更新信息
//            InfoRoom demo=new InfoRoom();
//            demo.setName("张");
//            demo.setId(4);
//            student.update(demo);
//            System.out.println(student.list());
//
//            //根据对象//根据id删除字段
//            student.delete(demo);
//            System.out.println(student.list());

            //获取数据库链接对象
//            AbstractQuery demo1=student.createQuery();
//            StringBuilder str=new StringBuilder(demo1.delete("student").where().sql()+"name='n'");
//            System.out.println(demo1.sql()+"name='n'");
//            demo1.exec_and_close();
//            InfoRoom hanbi=new InfoRoom();
//            hanbi.setId(200);
//            hanbi.setName("200");
//
//            student.save(hanbi);



// StudentDao dao = new StudentDao();
//            System.out.println(dao.load(111));
//            for (InfoRoom student:dao.list())
//                System.out.println(student);
//            // 获取所有
//            dao.list().forEach(System.out::println);
//            // 根据id查询
//            System.out.println(dao.load(2));
//
//
//            // 更新
//            InfoRoom load = dao.load(1);
//
//            load.setName("我");
//            dao.update(load);
//            System.out.println(load.info());
//            // 获取所有
//            dao.list().forEach(System.out::println);
//
//            // 根据对象删除
//            InfoRoom student = new InfoRoom();
//            student.setId(2);
//            dao.delete(student);
//
//             //获取所有对象
//            dao.list().forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
