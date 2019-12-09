package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;

@AnnotationTable(table="info",clazz = Info.class)
public class Info extends DefaultEntity {

    //房间类型
    @AnnotationField(col_name = "info_type", sql_type = "varchar",
            size = 20, field_name = "info_type", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String info_type;

    //房间面积
    @AnnotationField(col_name = "area", sql_type = "int",
            size = 20, field_name = "area", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer area;

    //额定人数
    @AnnotationField(col_name = "rated_people", sql_type = "int",
            size = 20, field_name = "rated_people", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer rated_people;

    //床数
    @AnnotationField(col_name = "rated_bed", sql_type = "int",
            size = 20, field_name = "rated_bed", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer rated_bed;

    //是否有空调
    @AnnotationField(col_name = "air_conditioning", sql_type = "char",
            size = 2, field_name = "air_conditioning", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String air_conditioning;

    //是否有电视
    @AnnotationField(col_name = "TV", sql_type = "char",
            size = 2, field_name = "TV", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String TV;

    //卫生间
    @AnnotationField(col_name = "reset", sql_type = "char",
            size = 10, field_name = "reset", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String reset;

    //房间电话
    @AnnotationField(col_name = "phone", sql_type = "char",
            size = 15, field_name = "phone", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String phone;

    //房间备注
    @AnnotationField(col_name = "ps", sql_type = "char",
            size = 100, field_name = "ps", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String ps;

    public String getReset() {
        return reset;
    }

    public Info setReset(String reset) {
        this.reset = reset;
        return this;
    }

    public String getPs() {
        return ps;
    }

    public Info setPs(String ps) {
        this.ps = ps;
        return this;
    }

    public Integer getRated_people() {
        return rated_people;
    }

    public Info setRated_people(Integer rated_people) {
        this.rated_people = rated_people;
        return this;
    }


    public Integer getArea() {
        return area;
    }

    public Info setArea(Integer area) {
        this.area = area;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Info setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getTV() {
        return TV;
    }

    public Info setTV(String TV) {
        this.TV = TV;
        return this;
    }

    public String getAir_conditioning() {
        return air_conditioning;
    }

    public Info setAir_conditioning(String air_conditioning) {
        this.air_conditioning = air_conditioning;
        return this;
    }

    public Integer getRated_bed() {
        return rated_bed;
    }

    public Info setRated_bed(Integer rated_bed) {
        this.rated_bed = rated_bed;
        return this;
    }

    public String getInfo_type() {
        return info_type;
    }

    public Info setInfo_type(String info_type) {
        this.info_type = info_type;
        return this;
    }

    @Override
    public String toString() {
        return "Info{" +
                "info_type='" + info_type + '\'' +
                ", area=" + area +
                ", rated_people=" + rated_people +
                ", rated_bed=" + rated_bed +
                ", air_conditioning='" + air_conditioning + '\'' +
                ", TV='" + TV + '\'' +
                ", reset='" + reset + '\'' +
                ", phone='" + phone + '\'' +
                ", ps='" + ps + '\'' +
                '}';
    }
}
