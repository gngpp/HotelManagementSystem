package mvcpro.model.entity;

import com.lqing.orm.internal.entity.DefaultEntity;

public class RoomStandard extends DefaultEntity {
        private  String room_id;
        private  String room_type;
        private  String room_floor;
        private  Integer room_price;
        private  String room_remark;

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_remark() {
        return room_remark;
    }

    public void setRoom_remark(String room_remark) {
        this.room_remark = room_remark;
    }

    public Integer getRoom_price() {
        return room_price;
    }

    public void setRoom_price(Integer room_price) {
        this.room_price = room_price;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_floor() {
        return room_floor;
    }

    public void setRoom_floor(String room_floor) {
        this.room_floor = room_floor;
    }
}
