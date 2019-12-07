package mvcpro.model.entity;

import com.lqing.orm.internal.entity.DefaultEntity;

import java.util.Date;

public class BookRoom extends DefaultEntity {
    private String room_id;
    private String room_type;
    private Integer room_price;
    private String room_peple_id;
    private Date room_in_date;
    private String room_discount;
    private Date room_out_date;
    private Integer room_amout;

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Integer getRoom_price() {
        return room_price;
    }

    public void setRoom_price(Integer room_price) {
        this.room_price = room_price;
    }

    public String getRoom_peple_id() {
        return room_peple_id;
    }

    public void setRoom_peple_id(String room_peple_id) {
        this.room_peple_id = room_peple_id;
    }

    public Date getRoom_out_date() {
        return room_out_date;
    }

    public void setRoom_out_date(Date room_out_date) {
        this.room_out_date = room_out_date;
    }

    public Date getRoom_in_date() {
        return room_in_date;
    }

    public void setRoom_in_date(Date room_in_date) {
        this.room_in_date = room_in_date;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_discount() {
        return room_discount;
    }

    public void setRoom_discount(String room_discount) {
        this.room_discount = room_discount;
    }

    public Integer getRoom_amout() {
        return room_amout;
    }

    public void setRoom_amout(Integer room_amout) {
        this.room_amout = room_amout;
    }
}
