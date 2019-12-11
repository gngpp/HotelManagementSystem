package mvcpro.view.server;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import mvcpro.model.entity.StandardRoom;

public class StandardRoomData {
    private StandardRoom standardRoom;
    private SimpleStringProperty room_type;
    private SimpleStringProperty room_floor;
    private SimpleIntegerProperty room_price;
    private SimpleStringProperty room_remark;
    private SimpleIntegerProperty room_id_number;


    public StandardRoomData(StandardRoom standardRoom){
        this.standardRoom=new StandardRoom();
        this.room_floor=new SimpleStringProperty(standardRoom.getRoom_floor());
        this.room_type=new SimpleStringProperty(standardRoom.getRoom_type());
        this.room_price=new SimpleIntegerProperty(standardRoom.getRoom_price());
        this.room_remark=new SimpleStringProperty(standardRoom.getRoom_remark());
        this.room_id_number=new SimpleIntegerProperty(standardRoom.getRoom_id_number());
    }

    public StandardRoom StandardRoomToEntity(){
        this.standardRoom.setRoom_id_number(room_id_number.get());
        this.standardRoom.setRoom_floor(room_floor.get());
        this.standardRoom.setRoom_price(room_price.get());
        this.standardRoom.setRoom_type(room_type.get());
        this.standardRoom.setRoom_remark(room_remark.get());
        return standardRoom;
    }

    public String getRoom_type() {
        return room_type.get();
    }

    public SimpleStringProperty room_typeProperty() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type.set(room_type);
    }

    public String getRoom_remark() {
        return room_remark.get();
    }

    public SimpleStringProperty room_remarkProperty() {
        return room_remark;
    }

    public void setRoom_remark(String room_remark) {
        this.room_remark.set(room_remark);
    }

    public int getRoom_id_number() {
        return room_id_number.get();
    }

    public SimpleIntegerProperty room_id_numberProperty() {
        return room_id_number;
    }

    public void setRoom_id_number(int room_id_number) {
        this.room_id_number.set(room_id_number);
    }

    public int getRoom_price() {
        return room_price.get();
    }

    public SimpleIntegerProperty room_priceProperty() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price.set(room_price);
    }

    public String getRoom_floor() {
        return room_floor.get();
    }

    public SimpleStringProperty room_floorProperty() {
        return room_floor;
    }

    public void setRoom_floor(String room_floor) {
        this.room_floor.set(room_floor);
    }
}
