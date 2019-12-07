package mvcpro.model.entity;

import com.lqing.orm.internal.conf.adapter.EntityInfo;
import com.lqing.orm.internal.entity.DefaultEntity;
import com.lqing.orm.internal.entity.EntityValue;
import com.lqing.orm.internal.entity.IEntity;
import com.lqing.orm.internal.entity.adapter.IEntityAdapter;

public class Client extends DefaultEntity {
    private String client_name;
    private String client_sex;
    private String client_native;
    private Integer client_id;
    private String client_phone;

    public Client(String client_name,String client_sex,String client_native,Integer client_id,String client_phone) {
        this.client_id=client_id;
        this.client_name=client_name;
        this.client_native=client_native;
        this.client_sex=client_sex;
        this.client_phone=client_phone;
    }


    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getClient_native() {
        return client_native;
    }

    public void setClient_native(String client_native) {
        this.client_native = client_native;
    }

    public String getClient_sex() {
        return client_sex;
    }

    public void setClient_sex(String client_sex) {
        this.client_sex = client_sex;
    }

}
