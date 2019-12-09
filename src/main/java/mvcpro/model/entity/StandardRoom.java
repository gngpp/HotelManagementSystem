package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;
@AnnotationTable(table = "standard_room",clazz = StandardRoom.class)
public class StandardRoom extends DefaultEntity {
    @AnnotationField(col_name = "room_id", sql_type = "int",
            size = 20, field_name = "room_id", java_type = "Integer",
            is_autoincrement = true, is_primary_key = true)
        private  Integer room_id;

    @AnnotationField(col_name = "room_type", sql_type = "char",
            size = 20, field_name = "room_type", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
        private  String room_type;

    @AnnotationField(col_name = "room_floor", sql_type = "char",
            size = 10, field_name = "room_floor", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
        private  String room_floor;

    @AnnotationField(col_name = "room_price", sql_type = "int",
            size = 20, field_name = "room_price", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
        private  Integer room_price;

    @AnnotationField(col_name = "room_remark", sql_type = "char",
            size = 255, field_name = "room_remark", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
        private  String room_remark;

    @AnnotationField(col_name = "room_id_number", sql_type = "int",
            size = 20, field_name = "room_id_number", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
        private Integer room_id_number;

    public String getRoom_floor() {
        return room_floor;
    }

    public StandardRoom setRoom_floor(String room_floor) {
        this.room_floor = room_floor;
        return this;
    }

    public String getRoom_type() {
        return room_type;
    }

    public StandardRoom setRoom_type(String room_type) {
        this.room_type = room_type;
        return this;
    }

    public String getRoom_remark() {
        return room_remark;
    }

    public StandardRoom setRoom_remark(String room_remark) {
        this.room_remark = room_remark;
        return this;
    }

    public Integer getRoom_price() {
        return room_price;
    }

    public StandardRoom setRoom_price(Integer room_price) {
        this.room_price = room_price;
        return this;
    }

    public Integer getRoom_id_number() {
        return room_id_number;
    }

    public StandardRoom setRoom_id_number(Integer room_id_number) {
        this.room_id_number = room_id_number;
        return this;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public StandardRoom setRoom_id(Integer room_id) {
        this.room_id = room_id;
        return this;
    }

    @Override
    public String toString() {
        return "StandardRoom{" +
                "room_id=" + room_id +
                ", room_type='" + room_type + '\'' +
                ", room_floor='" + room_floor + '\'' +
                ", room_price=" + room_price +
                ", room_remark='" + room_remark + '\'' +
                ", room_id_number=" + room_id_number +
                '}';
    }
}
