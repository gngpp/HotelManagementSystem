package mvcpro.view.main.server;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import mvcpro.model.entity.User;

public class UserEx {
    public User user;
    private SimpleStringProperty a;
    private SimpleStringProperty b;
    private SimpleIntegerProperty c;
    public UserEx(User user){
        this.user=new User();
        this.a=new SimpleStringProperty(user.getId());
        this.b=new SimpleStringProperty(user.getPassword());
        this.c=new SimpleIntegerProperty(user.getUserType());
    }

    public User UserExToEntity(){
        this.user.setId(a.get());
        return user;
    }

    public String getUserId(){
        return a.get();
    }

    public void setUserId(String id){
        a.set(id);
    }

    public String getPassword(){
        return b.get();
    }

    public void setPassword(String password){
        b.set(password);
    }

    public Integer getUserType(){
        return c.get();
    }

    public void setUserType(Integer userType){
        c.set(userType);
    }
}
