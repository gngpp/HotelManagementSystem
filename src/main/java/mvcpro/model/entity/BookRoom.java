package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;

import java.util.Date;

@AnnotationTable(table = "booking_room", clazz = BookRoom.class)
public class BookRoom extends DefaultEntity {
        //客房编号，自增，作为内部码
    @AnnotationField(col_name = "room_id", sql_type = "int",
            size = 20, field_name = "room_id", java_type = "Integer",
            is_autoincrement = true, is_primary_key = true)
    private Integer room_id;

        //客房类型
    @AnnotationField(col_name = "room_id", sql_type = "int",
            size = 20, field_name = "room_id", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private String room_type;


        //客房单价
    @AnnotationField(col_name = "room_price", sql_type = "int",
            size = 11, field_name = "room_price", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer room_price;


        //客户编号
    @AnnotationField(col_name = "room_peple_id", sql_type = "char",
            size = 20, field_name = "room_peple_id", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_peple_id;

        //客户姓名
    @AnnotationField(col_name = "room_peple_name", sql_type = "char",
            size = 10, field_name = "room_peple_name", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_peple_name;


    //入住时间
    @AnnotationField(col_name = "room_in_date", sql_type = "datetime",
            size = 255, field_name = "room_in_date", java_type = "Date",
            is_autoincrement = false, is_primary_key = false)
    private Date room_in_date;


    //折扣
    @AnnotationField(col_name = "room_discount", sql_type = "char",
            size = 20, field_name = "room_discount", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_discount;


    //结算时间
    @AnnotationField(col_name = "room_out_date", sql_type = "datetime",
            size = 255, field_name = "room_out_date", java_type = "Date",
            is_autoincrement = false, is_primary_key = false)
    private Date room_out_date;

    //总金额
    @AnnotationField(col_name = "room_amout", sql_type = "int",
            size = 20, field_name = "room_amout", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer room_amout;


    //客房编号
    @AnnotationField(col_name = "room_id_number", sql_type = "int",
            size = 11, field_name = "room_id_number", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer room_id_number;

    //备注
    @AnnotationField(col_name = "room_remark", sql_type = "char",
            size = 200, field_name = "room_remark", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_remark;

    public String getRoom_remark() {
        return room_remark;
    }

    public BookRoom setRoom_remark(String room_remark) {
        this.room_remark = room_remark;
        return this;
    }

    public Integer getRoom_id_number() {
        return room_id_number;
    }

    public BookRoom setRoom_id_number(Integer room_id_number) {
        this.room_id_number = room_id_number;
        return this;
    }

    public String getRoom_peple_name() {
        return room_peple_name;
    }

    public BookRoom setRoom_peple_name(String room_peple_name) {
        this.room_peple_name = room_peple_name;
        return this;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Integer getRoom_price() {
        return room_price;
    }

    public void setRoom_price(Integer room_price) {
        this.room_price = room_price;
    }

    public String getRoom_peple_id() {
        return room_peple_id;
    }

    public void setRoom_peple_id(String room_peple_id) {
        this.room_peple_id = room_peple_id;
    }

    public Date getRoom_out_date() {
        return room_out_date;
    }

    public void setRoom_out_date(Date room_out_date) {
        this.room_out_date = room_out_date;
    }

    public Date getRoom_in_date() {
        return room_in_date;
    }

    public void setRoom_in_date(Date room_in_date) {
        this.room_in_date = room_in_date;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getRoom_discount() {
        return room_discount;
    }

    public void setRoom_discount(String room_discount) {
        this.room_discount = room_discount;
    }

    public Integer getRoom_amout() {
        return room_amout;
    }

    public void setRoom_amout(Integer room_amout) {
        this.room_amout = room_amout;
    }

    @Override
    public String toString() {
        return "BookRoom{" +
                "room_id=" + room_id +
                ", room_type='" + room_type + '\'' +
                ", room_price=" + room_price +
                ", room_peple_id='" + room_peple_id + '\'' +
                ", room_peple_name='" + room_peple_name + '\'' +
                ", room_in_date=" + room_in_date +
                ", room_discount='" + room_discount + '\'' +
                ", room_out_date=" + room_out_date +
                ", room_amout=" + room_amout +
                ", room_id_number=" + room_id_number +
                ", room_remark='" + room_remark + '\'' +
                '}';
    }
}
