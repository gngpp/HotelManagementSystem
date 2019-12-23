package mvcpro.view.server;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import mvcpro.model.entity.Client;

public class ClientData {
    private Client client;
    private SimpleStringProperty client_name;
    private SimpleStringProperty client_sex;
    private SimpleStringProperty client_id_card;
    private SimpleStringProperty client_phone;
    private SimpleStringProperty client_native;
    private SimpleStringProperty client_id_number;

    public ClientData(Client client){
        this.client=new Client();
        this.client_name=new SimpleStringProperty(client.getClient_name());
        this.client_native=new SimpleStringProperty(client.getClient_native());
        this.client_id_card=new SimpleStringProperty(client.getClient_id_card());
        this.client_phone= new SimpleStringProperty(client.getClient_phone());
        this.client_sex=new SimpleStringProperty(client.getClient_sex());
        this.client_id_number=new SimpleStringProperty(client.getClient_id_number());
    }

    public Client ClientExToEntity(){
        this.client.setClient_name(client_name.get());
        this.client.setClient_sex(client_sex.get());
        this.client.setClient_id_card(client_id_card.get());
        this.client.setClient_native(client_native.get());
        this.client.setClient_phone(client_phone.get());
        this.client.setClient_id_number(client_id_number.get());
        return client;
    }


    public String getClient_name() {
        return client_name.get();
    }

    public SimpleStringProperty client_nameProperty() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name.set(client_name);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public String getClient_sex() {
        return client_sex.get();
    }

    public SimpleStringProperty client_sexProperty() {
        return client_sex;
    }

    public void setClient_sex(String client_sex) {
        this.client_sex.set(client_sex);
    }


    public String getClient_id_card() {
        return client_id_card.get();
    }

    public SimpleStringProperty client_id_cardProperty() {
        return client_id_card;
    }

    public void setClient_id_card(String client_id_card) {
        this.client_id_card.set(client_id_card);
    }

    public String getClient_phone() {
        return client_phone.get();
    }

    public SimpleStringProperty client_phoneProperty() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone.set(client_phone);
    }

    public String getClient_native() {
        return client_native.get();
    }

    public SimpleStringProperty client_nativeProperty() {
        return client_native;
    }

    public void setClient_native(String client_native) {
        this.client_native.set(client_native);
    }

    public String getClient_id_number() {
        return client_id_number.get();
    }

    public SimpleStringProperty client_id_numberProperty() {
        return client_id_number;
    }

    public void setClient_id_number(String client_id_number) {
        this.client_id_number.set(client_id_number);
    }
}
