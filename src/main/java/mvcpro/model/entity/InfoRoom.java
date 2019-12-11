package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;


@AnnotationTable(table = "info_room", clazz = InfoRoom.class)
public class InfoRoom extends DefaultEntity {
    @AnnotationField(col_name = "id", sql_type = "int",
                               size = 11, field_name = "id", java_type = "int",
                               is_autoincrement = true, is_primary_key = true)
    private int id;

    @AnnotationField(col_name = "type", sql_type = "char",
                   size = 20, field_name = "type", java_type = "String",
                   is_autoincrement = false, is_primary_key = false)
    private String type;

    @AnnotationField(col_name = "area", sql_type = "int",
            size = 20, field_name = "area", java_type = "int",
            is_autoincrement = false, is_primary_key = false)
    private int area;

    @AnnotationField(col_name = "iphone", sql_type = "varchar",
            size = 11, field_name = "iphone", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String iphone;

    public String getIphone() {
        return iphone;
    }

    @AnnotationField(col_name = "ps", sql_type = "varchar",
            size = 11, field_name = "ps", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String ps;

    @AnnotationField(col_name = "tv", sql_type = "varchar",
            size = 10, field_name = "tv", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String tv;

    @AnnotationField(col_name = "max_people", sql_type = "int",
            size = 11, field_name = "max_people", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer max_people;

    @AnnotationField(col_name = "max_bed", sql_type = "int",
            size = 11, field_name = "max_bed", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer max_bed;

     @AnnotationField(col_name = "rest", sql_type = "varchar",
            size = 11, field_name = "rest", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String rest;

    @AnnotationField(col_name = "air_conditioning", sql_type = "varchar",
            size = 11, field_name = "air_conditioning", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
     private String air_conditioning;

    public String getAir_conditioning() {
        return air_conditioning;
    }

    public InfoRoom setAir_conditioning(String air_conditioning) {
        this.air_conditioning = air_conditioning;
        return this;
    }

    public String getRest() {
        return rest;
    }

    public InfoRoom setRest(String rest) {
        this.rest = rest;
        return this;
    }

    public Integer getMax_bed() {
        return max_bed;
    }

    public InfoRoom setMax_bed(Integer max_bed) {
        this.max_bed = max_bed;
        return this;
    }

    public Integer getMax_people() {
        return max_people;
    }

    public InfoRoom setMax_people(Integer max_peple) {
        this.max_people = max_peple;
        return this;
    }

    public String getTv() {
        return tv;
    }

    public InfoRoom setTv(String tv) {
        this.tv = tv;
        return this;
    }

    public String getPs() {
        return ps;
    }

    public InfoRoom setPs(String ps) {
        this.ps = ps;
        return this;
    }

    public InfoRoom setIphone(String iphone) {
        this.iphone = iphone;
        return this;
    }

    public String getType() {
        return type;
    }

    public InfoRoom setType(String type) {
        this.type = type;
        return this;
    }

    public int getArea() {
        return area;
    }

    public InfoRoom setArea(int area) {
        this.area = area;
        return this;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "InfoRoom{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", area=" + area +
                ", iphone='" + iphone + '\'' +
                ", ps='" + ps + '\'' +
                ", tv='" + tv + '\'' +
                ", max_people=" + max_people +
                ", max_bed=" + max_bed +
                ", rest='" + rest + '\'' +
                ", air_conditioning='" + air_conditioning + '\'' +
                '}';
    }
}
