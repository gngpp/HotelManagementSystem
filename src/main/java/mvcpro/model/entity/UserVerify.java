package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;


@AnnotationTable(table = "users_verify", clazz = UserVerify.class)
public class UserVerify extends DefaultEntity {

    @AnnotationField(col_name = "UUID", sql_type = "int",
            size = 11, field_name = "UUID", java_type = "Integer",
            is_autoincrement = false, is_primary_key = true)
    private Integer UUID;

    @AnnotationField(col_name = "select_one", sql_type = "char",
            size = 255, field_name = "select_one", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String select_one;

    @AnnotationField(col_name = "select_two", sql_type = "char",
            size = 255, field_name = "select_two", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String select_two;

    @AnnotationField(col_name = "select_three", sql_type = "char",
            size = 255, field_name = "select_three", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String select_three;



    public String getSelect_three() {
        return select_three;
    }

    public UserVerify setSelect_three(String select_three) {
        this.select_three = select_three;
        return this;
    }

    public String getSelect_two() {
        return select_two;
    }

    public UserVerify setSelect_two(String select_two) {
        this.select_two = select_two;
        return this;
    }

    public String getSelect_one() {
        return select_one;
    }

    public UserVerify setSelect_one(String select_one) {
        this.select_one = select_one;
        return this;
    }

    public Integer getUUID() {
        return UUID;
    }

    public UserVerify setUUID(Integer UUID) {
        this.UUID = UUID;
        return this;
    }

    @Override
    public String toString() {
        return "UserVerify{" +
                "UUID=" + UUID +
                ", select_one='" + select_one + '\'' +
                ", select_two='" + select_two + '\'' +
                ", select_three='" + select_three + '\'' +
                '}';
    }
}
