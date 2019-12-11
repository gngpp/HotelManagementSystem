package mvcpro.view.server;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import mvcpro.model.entity.BookRoom;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookRoomData {
    private BookRoom bookRoom;
    private SimpleStringProperty room_type;
    private SimpleIntegerProperty room_price;
    private SimpleStringProperty room_peple_id;
    private SimpleStringProperty room_in_date;
    private SimpleStringProperty room_out_date;
    private SimpleStringProperty room_discount;
    private SimpleIntegerProperty room_amout;
    private SimpleStringProperty  room_peple_name;
    private SimpleIntegerProperty room_id_number;
    private SimpleStringProperty room_remark;

    public BookRoomData(BookRoom bookRoom){
        this.room_id_number=new SimpleIntegerProperty(bookRoom.getRoom_id_number());
        this.room_amout= new SimpleIntegerProperty(bookRoom.getRoom_amout());
        this.room_discount=new SimpleStringProperty((bookRoom.getRoom_discount()));
        this.room_peple_id=new SimpleStringProperty(bookRoom.getRoom_peple_id());
        this.room_peple_name=new SimpleStringProperty(bookRoom.getRoom_peple_name());
        this.room_in_date=new SimpleStringProperty(bookRoom.getRoom_in_date().toString());
        this.room_out_date=new SimpleStringProperty(bookRoom.getRoom_out_date().toString());
        this.room_price=new SimpleIntegerProperty(bookRoom.getRoom_price());
        this.room_remark=new SimpleStringProperty(bookRoom.getRoom_remark());
        this.room_type=new SimpleStringProperty(bookRoom.getRoom_type());
    }
    public BookRoom BookRoomExToEntity() throws ParseException {
        this.bookRoom.setRoom_id_number(room_id_number.get());
        this.bookRoom.setRoom_price(room_price.get());
        this.bookRoom.setRoom_peple_id(room_peple_id.get());
        //String转Date
        this.bookRoom.setRoom_in_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(room_in_date.get()));
        this.bookRoom.setRoom_out_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(room_out_date.get()));
        this.bookRoom.setRoom_peple_name(room_peple_name.get());
        this.bookRoom.setRoom_amout(room_amout.get());
        this.bookRoom.setRoom_discount(room_discount.get());
        this.bookRoom.setRoom_remark(room_remark.get());
        this.bookRoom.setRoom_type(room_type.get());
        return bookRoom;
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

    public int getRoom_price() {
        return room_price.get();
    }

    public SimpleIntegerProperty room_priceProperty() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price.set(room_price);
    }

    public String getRoom_in_date() {
        return room_in_date.get();
    }

    public SimpleStringProperty room_in_dateProperty() {
        return room_in_date;
    }

    public void setRoom_in_date(String room_in_date) {
        this.room_in_date.set(room_in_date);
    }

    public String getRoom_peple_name() {
        return room_peple_name.get();
    }

    public SimpleStringProperty room_peple_nameProperty() {
        return room_peple_name;
    }

    public void setRoom_peple_name(String room_peple_name) {
        this.room_peple_name.set(room_peple_name);
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

    public String getRoom_peple_id() {
        return room_peple_id.get();
    }

    public SimpleStringProperty room_peple_idProperty() {
        return room_peple_id;
    }

    public void setRoom_peple_id(String room_peple_id) {
        this.room_peple_id.set(room_peple_id);
    }

    public int getRoom_amout() {
        return room_amout.get();
    }

    public SimpleIntegerProperty room_amoutProperty() {
        return room_amout;
    }

    public void setRoom_amout(int room_amout) {
        this.room_amout.set(room_amout);
    }

    public String getRoom_out_date() {
        return room_out_date.get();
    }

    public SimpleStringProperty room_out_dateProperty() {
        return room_out_date;
    }

    public void setRoom_out_date(String room_out_date) {
        this.room_out_date.set(room_out_date);
    }

    public String getRoom_discount() {
        return room_discount.get();
    }

    public SimpleStringProperty room_discountProperty() {
        return room_discount;
    }

    public void setRoom_discount(String room_discount) {
        this.room_discount.set(room_discount);
    }

    public BookRoom getBookRoom() {
        return bookRoom;
    }

    public void setBookRoom(BookRoom bookRoom) {
        this.bookRoom = bookRoom;
    }
}
