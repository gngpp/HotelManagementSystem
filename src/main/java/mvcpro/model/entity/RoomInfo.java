package mvcpro.model.entity;


import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;

@AnnotationTable(table = "room_info", clazz = RoomInfo.class)
public class RoomInfo extends DefaultEntity {

    @AnnotationField(col_name = "room_infocol", sql_type = "varchar",
            size = 45, field_name = "room_info_col", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_info_col;

    @AnnotationField(col_name = "room_infocol1", sql_type = "varchar",
            size = 45, field_name = "room_info_col1", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_info_col1;

    @AnnotationField(col_name = "room_infocol2", sql_type = "varchar",
            size = 45, field_name = "room_info_col2", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String room_info_col2;

    public String getRoom_info_col() {
        return room_info_col;
    }

    public String getRoom_info_col1() {
        return room_info_col1;
    }

    public String getRoom_info_col2() {
        return room_info_col2;
    }

    public void setRoom_info_col(String room_info_col) {
        this.room_info_col = room_info_col;
    }

    public void setRoom_info_col1(String room_info_col1) {
        this.room_info_col1 = room_info_col1;

    }

    public void setRoom_info_col2(String room_info_col2) {
        this.room_info_col2 = room_info_col2;
    }

    @Override
    public String toString() {
        return "RoomInfo{" +
                "room_infocol='" + room_info_col + '\'' +
                ", room_infocol1='" + room_info_col1 + '\'' +
                ", room_infocol2='" + room_info_col2 + '\'' +
                '}';
    }
}
