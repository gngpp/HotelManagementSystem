package com.lqing.orm.test;

import com.lqing.orm.internal.SimpleDaoImpl;
import com.lqing.orm.internal.conf.ConfigureFactory;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.wrapper.EntityList;
import com.lqing.orm.utils.PkgScanner;

import java.io.IOException;

class StudentDao extends SimpleDaoImpl<Student>{

}

public class Test {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        try {

            System.out.println(dao.load(111));
            for (Student student:dao.list())
                System.out.println(student);
            // 获取所有
            dao.list().forEach(System.out::println);
            // 根据id查询
            System.out.println(dao.load(2));


            // 更新
            Student load = dao.load(110);
            load.setName("我");
            dao.update(load);
            System.out.println(load.info());
            // 获取所有
            dao.list().forEach(System.out::println);

            // 根据对象删除
            Student student = new Student();
            student.setId(2);
            dao.delete(student);

             //获取所有对象
            dao.list().forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
