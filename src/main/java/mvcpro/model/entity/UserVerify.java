package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;

@AnnotationTable(table = "users_verify", clazz = UserVerify.class)
public class UserVerify extends DefaultEntity {
    @AnnotationField(col_name = "select_one", sql_type = "varchar",
            size = 255, field_name = "selectOne", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String selectOne;

    @AnnotationField(col_name = "select_two", sql_type = "varchar",
            size = 255, field_name = "selectTwo", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String  selectTwo;

    @AnnotationField(col_name = "select_three", sql_type = "varchar",
            size = 255, field_name = "selectThree", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String selectThree;

    @AnnotationField(col_name = "UUID", sql_type = "int",
            size = 11, field_name = "UUID", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer UUID;

    public Integer getUUID() {
        return UUID;
    }

    public UserVerify setUUID(Integer UUID) {
        this.UUID = UUID;
        return this;
    }

    public String getSelectThree() {
        return selectThree;
    }

    public UserVerify setSelectThree(String selectThree) {
        this.selectThree = selectThree;
        return this;
    }

    public String getSelectTwo() {
        return selectTwo;
    }

    public UserVerify setSelectTwo(String selectTwo) {
        this.selectTwo = selectTwo;
        return this;
    }

    public String getSelectOne() {
        return selectOne;
    }

    public UserVerify setSelectOne(String selectOne) {
        this.selectOne = selectOne;
        return this;
    }

    @Override
    public String toString() {
        return "UserVerify{" +
                "selectOne='" + selectOne + '\'' +
                ", selectTwo='" + selectTwo + '\'' +
                ", selectThree='" + selectThree + '\'' +
                ", UUID=" + UUID +
                '}';
    }
}
