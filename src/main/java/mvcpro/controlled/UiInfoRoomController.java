package mvcpro.controlled;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mvcpro.model.dao.InfoRoomDao;
import mvcpro.model.dao.StandardRoomDao;
import mvcpro.model.entity.InfoRoom;
import mvcpro.model.entity.StandardRoom;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UiInfoRoomController {
    private Stage uiInfoRoom;

    private StandardRoomDao standardRoomDao;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txf_maxPeople_info;

    @FXML
    private ComboBox<String> cbx_air_conditioning_info;

    @FXML
    private TextField txf_area_info;

    @FXML
    private ComboBox<Integer> cbx_IdNumber_info;

    @FXML
    private TextField txf_phone_info;

    @FXML
    private ComboBox<String> cbx_tv_info;

    @FXML
    private TextField txf_bed_info;

    @FXML
    private ComboBox<String> cbx_rest_info;

    @FXML
    void ac_check_info(ActionEvent event) {

    }

    @FXML
    void initialize() throws Exception {
        standardRoomDao=new StandardRoomDao();
        List<Integer> arrayList=new ArrayList<>();
        for (StandardRoom standardRoom:standardRoomDao.list())
                arrayList.add(standardRoom.getRoom_id_number());
            cbx_IdNumber_info.getItems().setAll(arrayList);
            cbx_air_conditioning_info.getItems().setAll("有","无");
            cbx_rest_info.getItems().setAll("单间","双间");
            cbx_tv_info.getItems().setAll("IPTV","网络电视");
    }

    public void setMainStage(Stage mainStage) {
        this.uiInfoRoom=mainStage;
    }
}
