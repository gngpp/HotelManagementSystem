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
    private SimpleStringProperty picture;
    public UserData(User user){
        this.user=new User();
        this.id=new SimpleStringProperty(user.getId());
        this.password=new SimpleStringProperty(user.getPassword());
        this.userType=new SimpleStringProperty(user.getUserType());
        this.UUID=new SimpleIntegerProperty(user.getUUID());
        this.question_one=new SimpleStringProperty(user.getQuestion_one());
        this.question_two=new SimpleStringProperty(user.getQuestion_two());
        this.question_three=new SimpleStringProperty(user.getQuestion_three());
        this.picture=new SimpleStringProperty(user.getPicture());
    }

    public User userToEntity(){
        this.user.setId(id.get());
        this.user.setPassword(password.get());
        this.user.setUserType(userType.get());
        this.user.setUUID(UUID.get());
         this.user.setQuestion_one(question_one.get());
        this.user.setQuestion_two(question_two.get());
        this.user.setQuestion_three(question_three.get());
        this.user.setPicture(picture.get());
        return user;
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getUserType() {
        return userType.get();
    }

    public SimpleStringProperty userTypeProperty() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType.set(userType);
    }

    public String getQuestion_three() {
        return question_three.get();
    }

    public SimpleStringProperty question_threeProperty() {
        return question_three;
    }

    public void setQuestion_three(String question_three) {
        this.question_three.set(question_three);
    }

    public String getQuestion_one() {
        return question_one.get();
    }

    public SimpleStringProperty question_oneProperty() {
        return question_one;
    }

    public void setQuestion_one(String question_one) {
        this.question_one.set(question_one);
    }

    public String getQuestion_two() {
        return question_two.get();
    }

    public SimpleStringProperty question_twoProperty() {
        return question_two;
    }

    public void setQuestion_two(String question_two) {
        this.question_two.set(question_two);
    }

    public String getPicture() {
        return picture.get();
    }

    public SimpleStringProperty pictureProperty() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture.set(picture);
    }

    public int getUUID() {
        return UUID.get();
    }

    public SimpleIntegerProperty UUIDProperty() {
        return UUID;
    }

    public void setUUID(int UUID) {
        this.UUID.set(UUID);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
