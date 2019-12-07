package mvcpro.model.entity;

import com.lqing.orm.internal.entity.DefaultEntity;

public class RoomInfo extends DefaultEntity {
    private String room_type;
    private Integer room_area;
    private Integer room_rated_peple;
    private Integer room_rated_bed;
    private String room_air_conditioning;
    private String room_TV;
    private String room_rest;
    private String room_phone;

    public Integer getRoom_rated_bed() {
        return room_rated_bed;
    }

    public void setRoom_rated_bed(Integer room_rated_bed) {
        this.room_rated_bed = room_rated_bed;
    }

    public String getRoom_TV() {
        return room_TV;
    }

    public void setRoom_TV(String room_TV) {
        this.room_TV = room_TV;
    }

    public Integer getRoom_rated_peple() {
        return room_rated_peple;
    }

    public void setRoom_rated_peple(Integer room_rated_peple) {
        this.room_rated_peple = room_rated_peple;
    }

    public String getRoom_rest() {
        return room_rest;
    }

    public void setRoom_rest(String room_rest) {
        this.room_rest = room_rest;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_phone() {
        return room_phone;
    }

    public void setRoom_phone(String room_phone) {
        this.room_phone = room_phone;
    }

    public Integer getRoom_area() {
        return room_area;
    }

    public void setRoom_area(Integer room_area) {
        this.room_area = room_area;
    }

    public String getRoom_air_conditioning() {
        return room_air_conditioning;
    }

    public void setRoom_air_conditioning(String room_air_conditioning) {
        this.room_air_conditioning = room_air_conditioning;
    }
}
