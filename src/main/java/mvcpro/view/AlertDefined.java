package mvcpro.view;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class AlertDefined extends Alert {

    public AlertDefined(AlertType alertType, String title, String headerText) {
        super(alertType);
        super.setTitle(title);
        super.setHeaderText(headerText);
    }
}
