package mvcpro.model.entity;

import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;


@AnnotationTable(table = "test", clazz = TestVerify.class)
public class TestVerify extends DefaultEntity {

    public String getUUID() {
        return UUID;
    }

    public TestVerify setUUID(String UUID) {
        this.UUID = UUID;
        return this;
    }

    @AnnotationField(col_name = "UUID", sql_type = "varchar",
            size = 20, field_name = "UUID", java_type = "String",
            is_autoincrement = false, is_primary_key = true)
    private String UUID;

    @Override
    public String toString() {
        return "TestVerify{" +
                "UUID='" + UUID + '\'' +
                '}';
    }
}
