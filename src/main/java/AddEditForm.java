import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEditForm{
    @FXML
    private TextField add_edit_field;
@FXML
    public void initialize(ActionEvent actionEvent) {
        add_edit_field.setText(ViewDBForm.getEditableTest().f_name);
    }
}
