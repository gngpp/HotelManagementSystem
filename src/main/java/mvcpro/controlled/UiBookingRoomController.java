package mvcpro.controlled;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mvcpro.model.dao.*;
import mvcpro.model.entity.*;
import mvcpro.model.utils.Uitls;
import mvcpro.view.AlertDefined;
import mvcpro.view.server.BookRoomData;
import mvcpro.view.server.ClientData;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class UiBookingRoomController    implements Initializable {

    private Stage newStage;

    private InfoRoomDao infoRoomDao=new InfoRoomDao();

    private StandardRoomDao standardRoomDao=new StandardRoomDao();

    private BookRoomDao bookRoomDao=new BookRoomDao();

    private UserDao userDao=new UserDao();

    private ClientDao clientDao=new ClientDao();

    private ObservableList<BookRoomData> bookRoomData_list;

    private ObservableList<ClientData> clientData_list;

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
    private ComboBox<Integer> cbx_room_id_booking;

    @FXML
    private ComboBox<String> cbx_sex_booking;

    @FXML
    private TextField txf_native_booking;

    @FXML
    private TextField txf_phone_booking;

    @FXML
    private TextField txf_price_booking;

    @FXML TextField txf_name_booking;

    @FXML
    private ComboBox<Integer> cbx_people_id_booking;

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
        cbx_sex_booking.getItems().setAll("男", "女");
        date_booking.setValue(LocalDate.now());

        try {
            if (bookRoomDao.list().isEmpty()){
                for (InfoRoom infoRoom : infoRoomDao.list()) {
                    cbx_room_id_booking.getItems().add(infoRoom.getId_number());
                }
            }else {
                List<Integer> list=new ArrayList<>();
                for (InfoRoom next:infoRoomDao.list()){
                    list.add(next.getId_number());
                }

                for(InfoRoom infoRoom:infoRoomDao.list()){
                    for (BookRoom bookRoom:bookRoomDao.list()){
                        if(infoRoom.getId_number()==bookRoom.getRoom_id_number()){
                            list.remove(bookRoom.getRoom_id_number());
                        }
                    }
                }
                cbx_room_id_booking.getItems().setAll(list);
            }

            for (User user : userDao.list()) {
                cbx_people_id_booking.getItems().add(user.getUUID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        cbx_room_id_booking.setOnAction(event -> {
            try {
                    for (StandardRoom standardRoom : standardRoomDao.list()) {
                        if (standardRoom.getRoom_id_number() == cbx_room_id_booking.getValue()) {
                            txf_type_booking.setText(standardRoom.getRoom_type());
                            txf_price_booking.setText(String.valueOf(standardRoom.getRoom_price()));
                        }
                    }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }

    @FXML
    void ac_bookingCheck_booking(ActionEvent event) {
        if(txf_card_booking.getText().equals("")||
        txf_phone_booking.getText().equals("")||
        txf_price_booking.getText().equals("")||
        txf_type_booking.getText().equals("")||
        txf_native_booking.getText().equals("")||
        cbx_people_id_booking.getValue()==null||
        cbx_room_id_booking.getValue()==null||
        cbx_sex_booking.getValue()==null||
        date_booking.getValue()==null){
            new AlertDefined(Alert.AlertType.ERROR, "提示", "请完善信息").show();
            return;
        }


        if (!Uitls.isNumber(txf_phone_booking.getText())){
            new AlertDefined(Alert.AlertType.INFORMATION, "提示", "请输入正确的手机号。").show();
            return;
        }

        try{
            //更新数据两张表
            Client client=new Client();
            client.setClient_id_number(cbx_people_id_booking.getValue().toString());
            client.setClient_phone(txf_phone_booking.getText());
            client.setClient_native(txf_native_booking.getText());
            client.setClient_name(txf_name_booking.getText());
            client.setClient_sex(cbx_sex_booking.getValue());
            client.setClient_id_card(txf_card_booking.getText());



            BookRoom bookRoom=new BookRoom();
            bookRoom.setRoom_id_number(cbx_room_id_booking.getValue());
            bookRoom.setRoom_type(txf_type_booking.getText());
            bookRoom.setRoom_price(Integer.parseInt(txf_price_booking.getText()));
            bookRoom.setRoom_peple_id(cbx_people_id_booking.getValue().toString());
            bookRoom.setRoom_peple_name(txf_name_booking.getText());
            bookRoom.setRoom_sex(cbx_sex_booking.getValue());
            bookRoom.setRoom_card(txf_card_booking.getText());
            bookRoom.setRoom_phone(txf_phone_booking.getText());
            bookRoom.setRoom_in_date(new Date());

            if(bookRoomDao.save(bookRoom)&&clientDao.save(client)){
                clientData_list.add(new ClientData(client));
                for (BookRoom next:bookRoomDao.list()){
                    if (next.getRoom_id_number()==cbx_room_id_booking.getValue()){
                        bookRoomData_list.add(new BookRoomData(next));
                        newStage.close();
                    }

                }

            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            newStage.close();
        }
        newStage.close();
    }

    @FXML
    void ac_cancel_booking(ActionEvent event) {
        newStage.close();
    }

    public void setUiStage(Stage newStage) {
        this.newStage=newStage;
    }

    public void setBookRoomData(ObservableList<BookRoomData> bookRoomData_list){
            this.bookRoomData_list=bookRoomData_list;
    }

    public void setClientData(ObservableList<ClientData> clientData_list){
       this.clientData_list=clientData_list;
    }

}
