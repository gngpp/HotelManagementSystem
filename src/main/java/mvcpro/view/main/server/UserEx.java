package mvcpro.view.main.server;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import mvcpro.model.entity.User;

public class UserEx {
    public User user;
    private SimpleStringProperty id;
    private SimpleStringProperty password;
    private SimpleIntegerProperty userType;
    public UserEx(User user){
        this.user=new User();
        this.id=new SimpleStringProperty(user.getId());
        this.password=new SimpleStringProperty(user.getPassword());
        this.userType=new SimpleIntegerProperty(user.getUserType());
    }

    public User UserExToEntity(){
        this.user.setId(id.get());
        this.user.setPassword(password.get());
        this.user.setUserType(userType.get());
        return user;
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

    public Integer getUserType(){
        return userType.get();
    }

    public void setUserType(Integer userType){
        this.userType.set(userType);
    }

}
