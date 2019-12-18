package mvcpro.controlled;

import com.lqing.orm.utils.LoggerUtils;
import com.mysql.cj.util.LogUtils;
import com.sun.codemodel.internal.JTryBlock;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mvcpro.model.dao.InfoRoomDao;
import mvcpro.model.dao.StandardRoomDao;
import mvcpro.model.dao.UserDao;
import mvcpro.model.entity.InfoRoom;
import mvcpro.model.entity.StandardRoom;
import mvcpro.model.entity.User;
import mvcpro.model.utils.Uitls;
import mvcpro.view.AlertDefined;
import mvcpro.view.server.InfoRoomData;
import org.slf4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UiInfoRoomController {

    private static Logger LOG= LoggerUtils.getLogger(UiInfoRoomController.class);

    private Stage uiInfoRoom;

    private StandardRoomDao standardRoomDao;

    private InfoRoomDao infoRoomDao;

    private InfoRoom  infoRoom;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txf_maxPeople_info;

    @FXML
    private Button btn_alter_info;

    @FXML Button btn_check_info;

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


    private ObservableList<InfoRoomData> infoRoomData_list;

    @FXML
    void initialize() throws Exception {
        standardRoomDao=new StandardRoomDao();
        infoRoomDao=new InfoRoomDao();
        List<Integer> arrayList=new ArrayList<>();
        for (StandardRoom standardRoom : standardRoomDao.list())
            arrayList.add(standardRoom.getRoom_id_number());
        try{
                    for (StandardRoom standardRoom:standardRoomDao.list())
                        for (InfoRoom infoRoom:infoRoomDao.list())
                            if (standardRoom.getRoom_id_number()==infoRoom.getId_number())
                                arrayList.remove(standardRoom.getRoom_id_number());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            cbx_IdNumber_info.getItems().setAll(arrayList);
            cbx_air_conditioning_info.getItems().setAll("有","无");
            cbx_rest_info.getItems().setAll("单间","双间");
            cbx_tv_info.getItems().setAll("IPTV","网络电视");
        }

    }

    @FXML
    void ac_check_info(ActionEvent event) throws Exception {
        if (txf_area_info.getText().equals("")||txf_maxPeople_info.getText().equals("")||
                txf_bed_info.getText().equals("")||txf_phone_info.getText().equals("")||
                cbx_air_conditioning_info.getValue()==null||cbx_tv_info.getValue()==null||
                cbx_IdNumber_info.getValue()==null||cbx_rest_info.getValue()==null){
            new AlertDefined(Alert.AlertType.ERROR, "提示", "请完善信息").show();
            return;
        }

        if (!Uitls.isNumber(txf_maxPeople_info.getText()) ||
                !Uitls.isNumber(txf_area_info.getText())||
                !Uitls.isNumber(txf_bed_info.getText())){
            new AlertDefined(Alert.AlertType.INFORMATION, "提示", "人数/床数/房间面积请输入数字").show();
            return;
        }
        for (StandardRoom next:standardRoomDao.list())
            if(cbx_IdNumber_info.getValue()==next.getRoom_id_number()){
                InfoRoom infoRoom=new InfoRoom();
                infoRoom.setArea(Integer.parseInt(txf_area_info.getText()));
                infoRoom.setId_number(cbx_IdNumber_info.getValue());
                infoRoom.setIphone(txf_phone_info.getText());
                infoRoom.setMax_bed(Integer.parseInt(txf_bed_info.getText()));
                infoRoom.setMax_people(Integer.parseInt(txf_maxPeople_info.getText()));
                infoRoom.setTv(cbx_tv_info.getValue());
                infoRoom.setRest(cbx_rest_info.getValue());
                infoRoom.setAir_conditioning(cbx_air_conditioning_info.getValue());
                infoRoom.setType(next.getRoom_type());
                infoRoom.setPs(next.getRoom_remark());
                infoRoomData_list.add(new InfoRoomData(infoRoom));
                infoRoomDao.save(infoRoom);
                break;
            }

        this.uiInfoRoom.close();
    }

    @FXML
    void ac_alter_info(ActionEvent event){
        if (txf_area_info.getText().equals("")||txf_maxPeople_info.getText().equals("")||
                txf_bed_info.getText().equals("")||txf_phone_info.getText().equals("")||
                cbx_air_conditioning_info.getValue()==null||cbx_tv_info.getValue()==null ||
                cbx_rest_info.getValue()==null){
            new AlertDefined(Alert.AlertType.ERROR, "提示", "请完善信息").show();
            return;
        }

        if (!Uitls.isNumber(txf_maxPeople_info.getText()) ||
                !Uitls.isNumber(txf_area_info.getText())||
                !Uitls.isNumber(txf_bed_info.getText())){
            new AlertDefined(Alert.AlertType.INFORMATION, "提示", "人数/床数/房间面积请输入数字").show();
            return;
        }
        infoRoomData_list.removeAll(infoRoomData_list);
        InfoRoom infoRoom=getInfoRoom();
        infoRoom.setArea(Integer.parseInt(txf_area_info.getText()));
        infoRoom.setMax_people(Integer.parseInt(txf_maxPeople_info.getText()));
        infoRoom.setMax_bed(Integer.parseInt(txf_bed_info.getText()));
        infoRoom.setIphone(txf_phone_info.getText());
        infoRoom.setTv(cbx_tv_info.getValue());
        infoRoom.setRest(cbx_rest_info.getValue());
        try{
            infoRoomDao.update(infoRoom);
            for(InfoRoom next:infoRoomDao.list())
                infoRoomData_list.add(new InfoRoomData(next));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            uiInfoRoom.close();
        }
    }

    public void setMainStage(Stage mainStage) {
        this.uiInfoRoom=mainStage;
    }

    public void setInfoRoomData(ObservableList<InfoRoomData> infoRoomData_list) {
        this.infoRoomData_list = infoRoomData_list;
    }

    public InfoRoom getInfoRoom() {
        return infoRoom;
    }

    public void setInfoRoom(InfoRoom infoRoom,Boolean check) {
        if(check){
            this.infoRoom = infoRoom;
            btn_check_info.setVisible(false);
            cbx_IdNumber_info.setEditable(true);
            cbx_IdNumber_info.setVisible(false);
            cbx_rest_info.setValue(infoRoom.getRest());
            cbx_tv_info.setValue(infoRoom.getTv());
            cbx_air_conditioning_info.setValue(infoRoom.getAir_conditioning());
            txf_phone_info.setText(infoRoom.getIphone());
            txf_bed_info.setText(infoRoom.getMax_people().toString());
            txf_maxPeople_info.setText(infoRoom.getMax_people().toString());
            txf_area_info.setText(String.valueOf(infoRoom.getArea()));
        }

    }
}
