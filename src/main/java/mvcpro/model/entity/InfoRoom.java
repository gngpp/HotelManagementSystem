package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;


@AnnotationTable(table = "info_room",clazz = InfoRoom.class)
public class InfoRoom extends DefaultEntity {
    //房间类型
    @AnnotationField(col_name = "room_type", sql_type = "char",
            size = 20, field_name = "room_type", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_type;

    //房间面积
    @AnnotationField(col_name = "room_area", sql_type = "int",
            size = 20, field_name = "room_area", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer room_area;

    //额定人数
    @AnnotationField(col_name = "room_rated_people", sql_type = "int",
            size = 20, field_name = "room_rated_people", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private  Integer room_rated_people;

    //床数
    @AnnotationField(col_name = "room_rated_bed", sql_type = "int",
            size = 20, field_name = "room_rated_bed", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer room_rated_bed;

    //是否有空调
    @AnnotationField(col_name = "room_air_conditioning", sql_type = "char",
            size = 2, field_name = "room_air_conditioning", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_air_conditioning;

    //是否有电视
    @AnnotationField(col_name = "room_tv", sql_type = "char",
            size = 2, field_name = "room_tv", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_tv;

    //是否有卫生间
    @AnnotationField(col_name = "room_rest", sql_type = "char",
            size = 10, field_name = "room_rest", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_rest;

    //房间电话
    @AnnotationField(col_name = "room_phone", sql_type = "char",
            size = 15, field_name = "room_phone", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_phone;

    @AnnotationField(col_name = "room_ps", sql_type = "char",
            size = 50, field_name = "room_ps", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_ps;

    @Override
    public String toString() {
        return "InfoRoom{" +
                "room_type='" + room_type + '\'' +
                ", room_area=" + room_area +
                ", room_rated_people=" + room_rated_people +
                ", room_rated_bed=" + room_rated_bed +
                ", room_air_conditioning='" + room_air_conditioning + '\'' +
                ", room_TV='" + room_tv + '\'' +
                ", room_rest='" + room_rest + '\'' +
                ", room_phone='" + room_phone + '\'' +
                ", room_ps='" + room_ps + '\'' +
                '}';
    }

    public Integer getRoom_area() {
        return room_area;
    }

    public InfoRoom setRoom_area(Integer room_area) {
        this.room_area = room_area;
        return this;
    }

    public String getRoom_ps() {
        return room_ps;
    }

    public InfoRoom setRoom_ps(String room_ps) {
        this.room_ps = room_ps;
        return this;
    }

    public Integer getRoom_rated_bed() {
        return room_rated_bed;
    }

    public InfoRoom setRoom_rated_bed(Integer room_rated_bed) {
        this.room_rated_bed = room_rated_bed;
        return this;
    }

    public Integer getRoom_rated_people() {
        return room_rated_people;
    }

    public InfoRoom setRoom_rated_people(Integer room_rated_people) {
        this.room_rated_people = room_rated_people;
        return this;
    }

    public String getRoom_type() {
        return room_type;
    }

    public InfoRoom setRoom_type(String room_type) {
        this.room_type = room_type;
        return this;
    }

    public String getRoom_tv() {
        return room_tv;
    }

    public InfoRoom setRoom_tv(String room_tv) {
        this.room_tv = room_tv;
        return this;
    }

    public String getRoom_rest() {
        return room_rest;
    }

    public InfoRoom setRoom_rest(String room_rest) {
        this.room_rest = room_rest;
        return this;
    }

    public String getRoom_phone() {
        return room_phone;
    }

    public InfoRoom setRoom_phone(String room_phone) {
        this.room_phone = room_phone;
        return this;
    }

    public String getRoom_air_conditioning() {
        return room_air_conditioning;
    }

    public InfoRoom setRoom_air_conditioning(String room_air_conditioning) {
        this.room_air_conditioning = room_air_conditioning;
        return this;
    }
}
