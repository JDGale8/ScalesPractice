package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML public Label displayScale;

    public void handleNewScale(ActionEvent event) {
        String scale =majorScalesPractice.getSimpleMScale();
        displayScale.setText(scale);
    }

}
