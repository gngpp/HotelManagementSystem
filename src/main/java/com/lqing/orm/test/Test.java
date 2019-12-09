package com.lqing.orm.test;

import com.lqing.orm.internal.SimpleDaoImpl;

class StudentDao extends SimpleDaoImpl<Student>{

}

public class Test {
    public static void main(String[] args) {

        try {


        //    Connection connection=DriverManager.getConnection("数据库的url","root","你的数据库密码");
//          // System.out.println(connection);
            StudentDao student=new StudentDao();
            //获取所有对象的字段信息
            System.out.println(student.list());
//            student.list().forEach(System.out::println);
//            //分行遍历所有对象字段信息
//            student.list().forEach(System.out::println);
//            for(int i=0;i<10;i++){
//                Student test=new Student();
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
//            Student demo=new Student();
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
//            Student hanbi=new Student();
//            hanbi.setId(200);
//            hanbi.setName("200");
//
//            student.save(hanbi);



// StudentDao dao = new StudentDao();
//            System.out.println(dao.load(111));
//            for (Student student:dao.list())
//                System.out.println(student);
//            // 获取所有
//            dao.list().forEach(System.out::println);
//            // 根据id查询
//            System.out.println(dao.load(2));
//
//
//            // 更新
//            Student load = dao.load(1);
//
//            load.setName("我");
//            dao.update(load);
//            System.out.println(load.info());
//            // 获取所有
//            dao.list().forEach(System.out::println);
//
//            // 根据对象删除
//            Student student = new Student();
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
