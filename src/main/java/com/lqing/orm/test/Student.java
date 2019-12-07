package com.lqing.orm.test;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;


@AnnotationTable(table = "students", clazz = Student.class)
public class Student extends DefaultEntity {
    @AnnotationField(col_name = "id", sql_type = "int",
                               size = 11, field_name = "id", java_type = "int",
                               is_autoincrement = false, is_primary_key = true)
    private int id;

    @AnnotationField(col_name = "name", sql_type = "char",
                              size = 24, field_name = "name", java_type = "String",
                              is_autoincrement = false, is_primary_key = false)
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
