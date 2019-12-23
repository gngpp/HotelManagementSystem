package mvcpro.controlled;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import mvcpro.view.About;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {
        private Stage stage;


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setStage(Stage stage){
        this.stage=stage;
    }

    @FXML
    public void ac_close(javafx.event.ActionEvent event) {
        this.stage.close();
    }
}
