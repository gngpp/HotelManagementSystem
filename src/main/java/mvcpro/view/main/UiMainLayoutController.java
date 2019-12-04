package mvcpro.view.main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UiMainLayoutController {

    private Stage mainStage;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private Button mainMinimize;

    @FXML
    private Button browse;

    @FXML
    private Button mainExit;

    @FXML
    void CheckAdd(ActionEvent event) {
        System.out.println("add");
    }

    @FXML
    void CheckUadate(ActionEvent event) {
        System.out.println("update!");
    }

    @FXML
    void CheckDelete(ActionEvent event) {
        System.out.println("delete!");
    }

    @FXML
    void CheckBrower(ActionEvent event) {
        System.out.println("brower!");
    }

    @FXML
    void CheckMainExit(ActionEvent event){
        Platform.exit();
    }

    @FXML
    void CheckMainMinimize(ActionEvent event){
        mainStage.setIconified(true);
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    void systemClose(ActionEvent event){
        Platform.exit();
    }

    @FXML
    void initialize() {
        update.setFont(new Font("System", 13));
        delete.setFont(new Font("System", 13));
        add.setFont(new Font("System", 13));
        browse.setFont(new Font("System",13));
        mainExit.setFont(new Font("System", 13));
        mainMinimize.setFont(new Font("System",13));
    }


}




