package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;


@AnnotationTable(table = "users", clazz = User.class)
public class User extends DefaultEntity {
    @AnnotationField(col_name = "id", sql_type = "varchar",
            size = 20, field_name = "id", java_type = "String",
            is_autoincrement = false, is_primary_key = true)
    private String id;

    @AnnotationField(col_name = "password", sql_type = "varchar",
            size = 255, field_name = "password", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String password;

    @AnnotationField(col_name = "userType", sql_type = "Integer",
            size = 1, field_name = "userType", java_type = "Integer",
            is_autoincrement = false, is_primary_key = false)
    private Integer userType;

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id +
                "', password='" + password + '\'' +
                ",userType='"+userType+
                '}';
    }
}
