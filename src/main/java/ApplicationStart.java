import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationStart extends Application {
    public static Stage stage;
    public static Scene viewScene;
    public static Scene loginScene;
    public static Scene addEditScene;
    public static void main(String[] args) throws IOException {
        launch(args);
    }
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        String fxmlLogin = "/fxml/loginForm.fxml";
        FXMLLoader loaderLogin = new FXMLLoader();
        Parent LoginNode = loaderLogin.load(getClass().getResourceAsStream(fxmlLogin));
        loginScene = new Scene(LoginNode, 441, 289);

        String fxmlView = "/fxml/ViewDBForm.fxml";
        FXMLLoader loaderView = new FXMLLoader();
        Parent ViewNode = loaderView.load(getClass().getResourceAsStream(fxmlView));
        viewScene = new Scene(ViewNode, 600, 433);

        String fxmlAddEdit = "/fxml/AddEditForm.fxml";
        FXMLLoader loaderAddEdit = new FXMLLoader();
        Parent AddEditNode = loaderAddEdit.load(getClass().getResourceAsStream(fxmlAddEdit));
        addEditScene = new Scene(AddEditNode, 600, 433);

        stage.setTitle("DBClient");
        stage.setResizable(false);
        stage.setScene(loginScene);
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ApplicationStart.stage = stage;
    }

    public static Scene getViewScene() {
        return viewScene;
    }

    public static void setViewScene(Scene viewScene) {
        ApplicationStart.viewScene = viewScene;
    }

    public static Scene getLoginScene() {
        return loginScene;
    }

    public static void setLoginScene(Scene loginScene) {
        ApplicationStart.loginScene = loginScene;
    }

    public static Scene getAddEditScene() {
        return addEditScene;
    }

    public static void setAddEditScene(Scene addEditScene) {
        ApplicationStart.addEditScene = addEditScene;
    }
}
