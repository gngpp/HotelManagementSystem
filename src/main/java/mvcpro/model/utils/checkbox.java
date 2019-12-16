package mvcpro.model.utils;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

public class checkbox
{
    ComboBox comboBox =new ComboBox();
    public ObservableValue<ComboBox> getComboBox()
    {
        return new  ObservableValue<ComboBox>() {
            @Override
            public void addListener(ChangeListener<? super ComboBox> listener) {

            }

            @Override
            public void removeListener(ChangeListener<? super ComboBox> listener) {

            }

            @Override
            public ComboBox getValue() {
                return comboBox;
            }

            @Override
            public void addListener(InvalidationListener listener) {

            }

            @Override
            public void removeListener(InvalidationListener listener) {

            }
        };
    }
    public String getValue()
    {
        return (String) comboBox.getValue();
    }
}

