package mvcpro.view;

import javafx.scene.control.Alert;

public class AlertDefined extends Alert {

    public AlertDefined(AlertType alertType, String title, String headerText) {
        super(alertType);
        super.setTitle(title);
        super.setHeaderText(headerText);
    }
}
