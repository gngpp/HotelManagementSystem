package mvcpro.model.entity;

import com.lqing.orm.internal.conf.adapter.EntityInfo;
import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.DefaultEntity;
import com.lqing.orm.internal.entity.EntityValue;
import com.lqing.orm.internal.entity.IEntity;
import com.lqing.orm.internal.entity.adapter.IEntityAdapter;

@AnnotationTable(table="client",clazz = Client.class)
public class Client extends DefaultEntity {

    //客户的名字
    @AnnotationField(col_name = "client_name", sql_type = "char",
            size = 10, field_name = "client_name", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String client_name;

    //客户的性别
    @AnnotationField(col_name = "client_sex", sql_type = "char",
            size = 2, field_name = "client_sex", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String client_sex;

    //客户的籍贯
    @AnnotationField(col_name = "client_native", sql_type = "varchar",
            size = 30, field_name = "client_native", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String client_native;

    //客户的唯一id标识，主键
    @AnnotationField(col_name = "client_id", sql_type = "int",
            size = 30, field_name = "client_id", java_type = "Integer",
            is_autoincrement = true, is_primary_key = true)
    private Integer client_id;

    //客户的联系电话
    @AnnotationField(col_name = "client_phone", sql_type = "varchar",
            size = 255, field_name = "client_phone", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String client_phone;

    //客户的身份证
    @AnnotationField(col_name = "client_id_card", sql_type = "char",
            size = 20, field_name = "client_id_card", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String client_id_card;

    //客户的身份证
    @AnnotationField(col_name = "client_id_number", sql_type = "char",
            size = 20, field_name = "client_id_number", java_type = "String",
            is_autoincrement = false, is_primary_key = false)
    private String client_id_number;

    public String getClient_id_number() {
        return client_id_number;
    }

    public void setClient_id_number(String client_id_number) {
        this.client_id_number = client_id_number;
    }

    public String getClient_id_card() {
        return client_id_card;
    }

    public Client setClient_id_card(String client_id_card) {
        this.client_id_card = client_id_card;
        return this;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public Client setClient_phone(String client_phone) {
        this.client_phone = client_phone;
        return this;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public Client setClient_id(Integer client_id) {
        this.client_id = client_id;
        return this;
    }

    public String getClient_native() {
        return client_native;
    }

    public Client setClient_native(String client_native) {
        this.client_native = client_native;
        return this;
    }

    public String getClient_sex() {
        return client_sex;
    }

    public Client setClient_sex(String client_sex) {
        this.client_sex = client_sex;
        return this;
    }

    public String getClient_name() {
        return client_name;
    }

    public Client setClient_name(String client_name) {
        this.client_name = client_name;
        return this;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_name='" + client_name + '\'' +
                ", client_sex='" + client_sex + '\'' +
                ", client_native='" + client_native + '\'' +
                ", client_id=" + client_id +
                ", client_phone='" + client_phone + '\'' +
                ", client_id_card='" + client_id_card + '\'' +
                ", client_id_number='" + client_id_number + '\'' +
                '}';
    }
}
