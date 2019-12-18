package mvcpro.view.server;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import mvcpro.model.entity.BookRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookRoomData {
    private BookRoom bookRoom;
    private SimpleStringProperty room_type;
    private SimpleIntegerProperty room_price;
    private SimpleStringProperty room_peple_id;
    private SimpleStringProperty room_in_date;
    private SimpleStringProperty room_card;
    private SimpleStringProperty room_sex;
    private SimpleStringProperty  room_peple_name;
    private SimpleIntegerProperty room_id_number;
    private SimpleIntegerProperty rooo_id;
    private SimpleStringProperty room_phone;

    public BookRoomData(BookRoom bookRoom){
        this.bookRoom=new BookRoom();
        this.room_id_number=new SimpleIntegerProperty(bookRoom.getRoom_id_number());
        this.rooo_id=new SimpleIntegerProperty(bookRoom.getRoom_id());
        this.room_sex = new SimpleStringProperty(bookRoom.getRoom_sex());
        this.room_card=new SimpleStringProperty((bookRoom.getRoom_card()));
        this.room_peple_id=new SimpleStringProperty(bookRoom.getRoom_peple_id());
        this.room_peple_name=new SimpleStringProperty(bookRoom.getRoom_peple_name());
        this.room_in_date=new SimpleStringProperty(bookRoom.getRoom_in_date().toString());
        this.room_price=new SimpleIntegerProperty(bookRoom.getRoom_price());
        this.room_phone =new SimpleStringProperty(bookRoom.getRoom_phone());
        this.room_type=new SimpleStringProperty(bookRoom.getRoom_type());
    }
    public BookRoom bookRoomExToEntity() throws ParseException {
        this.bookRoom.setRoom_id_number(room_id_number.get());
        this.bookRoom.setRoom_id(rooo_id.get());
        this.bookRoom.setRoom_price(room_price.get());
        this.bookRoom.setRoom_peple_id(room_peple_id.get());
        //String转Date
        this.bookRoom.setRoom_in_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(room_in_date.get()));
        this.bookRoom.setRoom_peple_name(room_peple_name.get());
        this.bookRoom.setRoom_sex(room_sex.get());
        this.bookRoom.setRoom_card(room_card.get());
        this.bookRoom.setRoom_phone(room_phone.get());
        this.bookRoom.setRoom_type(room_type.get());
        return bookRoom;
    }

    public int getRooo_id() {
        return rooo_id.get();
    }

    public SimpleIntegerProperty rooo_idProperty() {
        return rooo_id;
    }

    public void setRooo_id(int rooo_id) {
        this.rooo_id.set(rooo_id);
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

    public String getRoom_phone() {
        return room_phone.get();
    }

    public SimpleStringProperty room_phoneProperty() {
        return room_phone;
    }

    public void setRoom_phone(String room_phone) {
        this.room_phone.set(room_phone);
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

    public String getRoom_sex() {
        return room_sex.get();
    }

    public SimpleStringProperty room_sexProperty() {
        return room_sex;
    }

    public void setRoom_sex(String room_sex) {
        this.room_sex.set(room_sex);
    }

    public String getRoom_card() {
        return room_card.get();
    }

    public SimpleStringProperty room_cardProperty() {
        return room_card;
    }

    public void setRoom_card(String room_card) {
        this.room_card.set(room_card);
    }

    public String getRoom_discount() {
        return room_card.get();
    }

    public SimpleStringProperty room_discountProperty() {
        return room_card;
    }

    public void setRoom_discount(String room_discount) {
        this.room_card.set(room_discount);
    }

    public BookRoom getBookRoom() {
        return bookRoom;
    }

    public void setBookRoom(BookRoom bookRoom) {
        this.bookRoom = bookRoom;
    }
}
