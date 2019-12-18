package mvcpro.controlled;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UiBookingRoomController    implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txf_type_booking;

    @FXML
    private TextField txf_card_booking;

    @FXML
    private DatePicker date_booking;

    @FXML
    private ComboBox<?> cbx_room_id_booking;

    @FXML
    private ComboBox<?> cbx_sex_booking;

    @FXML
    private TextField txf_phone_booking;

    @FXML
    private TextField txf_price_booking;

    @FXML
    private ComboBox<?> cbx_people_id_booking;

    @FXML
    void ac_bookingCheck_booking(ActionEvent event) {

    }

    @FXML
    void ac_cancel_booking(ActionEvent event) {

    }

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

    public void setUiStage(Stage newStage) {
    }
}
