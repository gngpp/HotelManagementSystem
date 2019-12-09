package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;
@AnnotationTable(table = "roomStandard",clazz = RoomStandard.class)
public class RoomStandard extends DefaultEntity {
    @AnnotationField(col_name = "id", sql_type = "int",
            size = 20, field_name = "id", java_type = "Integer",
            is_autoincrement = true, is_primary_key = true)
        private  Integer id;

    @AnnotationField(col_name = "type", sql_type = "char",
            size = 20, field_name = "type", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
        private  String type;

    @AnnotationField(col_name = "floor", sql_type = "char",
            size = 10, field_name = "floor", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
        private  String floor;

    @AnnotationField(col_name = "price", sql_type = "int",
            size = 20, field_name = "price", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
        private  Integer price;

    @AnnotationField(col_name = "remark", sql_type = "char",
            size = 255, field_name = "remark", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
        private  String remark;

    @AnnotationField(col_name = "id_number", sql_type = "int",
            size = 20, field_name = "id_number", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
        private Integer id_number;

    public Integer getId() {
        return id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getId_number() {
        return id_number;
    }

    public void setId_number(Integer id_number) {
        this.id_number = id_number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
