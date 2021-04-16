import Config.JdbcConfig;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LoginForm {
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passTextField;
    @FXML
    private Button loginButton;

    @FXML
    public void loginButtonPress(ActionEvent actionEvent){
        JdbcConfig.username = loginTextField.getText();
        JdbcConfig.password = passTextField.getText();
        ApplicationStart.getStage().setScene(ApplicationStart.getViewScene());
    }

}
