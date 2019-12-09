package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;


@AnnotationTable(table = "info_room", clazz = InfoRoom.class)
public class InfoRoom extends DefaultEntity {
    @AnnotationField(col_name = "id", sql_type = "int",
                               size = 11, field_name = "id", java_type = "int",
                               is_autoincrement = false, is_primary_key = true)
    private int id;

    @AnnotationField(col_name = "name", sql_type = "char",
                              size = 24, field_name = "name", java_type = "String",
                              is_autoincrement = false, is_primary_key = false)
    private String name;

    @AnnotationField(col_name = "type", sql_type = "char",
                   size = 20, field_name = "type", java_type = "String",
                   is_autoincrement = false, is_primary_key = false)
    private String type;

    @AnnotationField(col_name = "area", sql_type = "int",
                    size = 20, field_name = "area", java_type = "int",
                    is_autoincrement = false, is_primary_key = false)
    private int area;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }


}
