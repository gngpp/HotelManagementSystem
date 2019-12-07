package mvcpro.view.server;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import mvcpro.model.entity.User;

public class UserData {
    public User user;
    private SimpleStringProperty id;
    private SimpleStringProperty password;
    private SimpleStringProperty userType;
    private SimpleIntegerProperty UUID;
    public UserData(User user){
        this.user=new User();
        this.id=new SimpleStringProperty(user.getId());
        this.password=new SimpleStringProperty(user.getPassword());
        this.userType=new SimpleStringProperty(user.getUserType());
        this.UUID=new SimpleIntegerProperty(user.getUUID());
    }

    public User UserExToEntity(){
        this.user.setId(id.get());
        this.user.setPassword(password.get());
        this.user.setUserType(userType.get());
        this.user.setUUID(UUID.get());
        return user;
    }

    public Integer getUUID(){
        return UUID.get();
    }

    public void setUUID(Integer uuid){
        this.UUID.set(uuid);
    }
    public String getUserId(){
        return id.get();
    }

    public void setUserId(String id){
        this.id.set(id);
    }

    public String getPassword(){
        return id.get();
    }

    public void setPassword(String password){
        this.password.set(password);
    }

    public String getUserType(){
        return userType.get();
    }

    public void setUserType(String userType){
        this.userType.set(userType);
    }

}
