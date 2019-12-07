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
    private SimpleStringProperty question_one;
    private SimpleStringProperty question_two;
    private SimpleStringProperty question_three;
    public UserData(User user){
        this.user=new User();
        this.id=new SimpleStringProperty(user.getId());
        this.password=new SimpleStringProperty(user.getPassword());
        this.userType=new SimpleStringProperty(user.getUserType());
        this.UUID=new SimpleIntegerProperty(user.getUUID());
        this.question_one=new SimpleStringProperty(user.getQuestion_one());
        this.question_two=new SimpleStringProperty(user.getQuestion_two());
        this.question_three=new SimpleStringProperty(user.getQuestion_three());
    }

    public User UserExToEntity(){
        this.user.setId(id.get());
        this.user.setPassword(password.get());
        this.user.setUserType(userType.get());
        this.user.setUUID(UUID.get());
         this.user.setQuestion_one(question_one.get());
        this.user.setQuestion_two(question_two.get());
        this.user.setQuestion_three(question_three.get());
        return user;
    }

    public String getQuestion_one(){
        return question_one.get();
    }

    public void setQuestion_one(String question_one){
        this.question_one.set(question_one);
    }
    public String getQuestion_two(){
        return question_two.get();
    }

    public void setQuestion_two(String question_two){
        this.question_two.set(question_two);
    }

    public String getQuestion_three(){
        return question_three.get();
    }

    public void setQuestion_three(String question_three){
        this.question_three.set(question_three);
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
