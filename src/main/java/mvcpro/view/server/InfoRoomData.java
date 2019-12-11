package mvcpro.view.server;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import mvcpro.model.entity.InfoRoom;

public class InfoRoomData {
    private InfoRoom infoRoom;
    private SimpleIntegerProperty id;
    private SimpleStringProperty type;
    private SimpleIntegerProperty area;
    private SimpleStringProperty iphone;
    private SimpleStringProperty ps;
    private SimpleStringProperty tv;
    private SimpleIntegerProperty max_people;
    private SimpleIntegerProperty max_bed;
    private SimpleStringProperty rest;

    public InfoRoomData(InfoRoom infoRoom){
        this.infoRoom=new InfoRoom();
        id=new SimpleIntegerProperty(infoRoom.getId());
        type=new SimpleStringProperty(infoRoom.getType());
        tv=new SimpleStringProperty(infoRoom.getTv());
        area=new SimpleIntegerProperty(infoRoom.getArea());
        iphone=new SimpleStringProperty(infoRoom.getIphone());
        ps=new SimpleStringProperty(infoRoom.getPs());
        max_bed=new SimpleIntegerProperty(infoRoom.getMax_bed());
        max_people=new SimpleIntegerProperty(infoRoom.getMax_people());
        rest=new SimpleStringProperty(infoRoom.getRest());
    }

    public InfoRoom InfoRoomToEntity(){
        infoRoom.setId(id.get());
        infoRoom.setAir_conditioning(air_conditioning.get());
        infoRoom.setArea(area.get());
        infoRoom.setIphone(iphone.get());
        infoRoom.setType(type.get());
        infoRoom.setTv(tv.get());
        infoRoom.setMax_bed(max_bed.get());
        infoRoom.setMax_people(max_people.get());
        infoRoom.setRest(rest.get());
        return this.infoRoom;
    }

    public String getIphone() {
        return iphone.get();
    }

    public SimpleStringProperty iphoneProperty() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone.set(iphone);
    }

    public String getAir_conditioning() {
        return air_conditioning.get();
    }

    public SimpleStringProperty air_conditioningProperty() {
        return air_conditioning;
    }

    public void setAir_conditioning(String air_conditioning) {
        this.air_conditioning.set(air_conditioning);
    }

    public String getPs() {
        return ps.get();
    }

    public SimpleStringProperty psProperty() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps.set(ps);
    }

    public int getMax_people() {
        return max_people.get();
    }

    public SimpleIntegerProperty max_peopleProperty() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people.set(max_people);
    }

    public String getRest() {
        return rest.get();
    }

    public SimpleStringProperty restProperty() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest.set(rest);
    }

    public int getMax_bed() {
        return max_bed.get();
    }

    public SimpleIntegerProperty max_bedProperty() {
        return max_bed;
    }

    public void setMax_bed(int max_bed) {
        this.max_bed.set(max_bed);
    }

    public String getTv() {
        return tv.get();
    }

    public SimpleStringProperty tvProperty() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv.set(tv);
    }

    public int getArea() {
        return area.get();
    }

    public SimpleIntegerProperty areaProperty() {
        return area;
    }

    public void setArea(int area) {
        this.area.set(area);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    private SimpleStringProperty air_conditioning;

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public InfoRoom getInfoRoom() {
        return infoRoom;
    }

    public void setInfoRoom(InfoRoom infoRoom) {
        this.infoRoom = infoRoom;
    }
}
