import Config.JdbcConfig;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ViewDBForm implements Initializable {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
    public JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
    public static TestModel EditableTest;
    @FXML
    private TableView<TestModel> MainTable;
    @FXML
    private TableColumn<TestModel, Integer> id_Column;
    @FXML
    private TableColumn<TestModel, String> F_Name_Column;
    @FXML
    private TableColumn<TestModel, String> L_Name_Column;
    @FXML
    private TableColumn<TestModel, String> City_Column;
    @FXML
    private TableColumn<TestModel, Integer> Phone_Column;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            MainTable.setItems(getData());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        id_Column.setCellValueFactory(new PropertyValueFactory<>("id"));
        F_Name_Column.setCellValueFactory(new PropertyValueFactory<>("f_name"));
        L_Name_Column.setCellValueFactory(new PropertyValueFactory<>("l_name"));
        City_Column.setCellValueFactory(new PropertyValueFactory<>("city"));
        Phone_Column.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }
    public ObservableList<TestModel> getData() throws SQLException {
        ObservableList<TestModel> res = FXCollections.observableArrayList();
        List<String> set = jdbcTemplate.query("select * from \"main\"", (resultSet, i) -> resultSet.getInt("id")+";"+resultSet.getString("f_name")+";"+resultSet.getString("l_name")+";"+resultSet.getString("city")+";"+resultSet.getInt("phone"));
        System.out.println(set);
        String f_name, l_name, city;
        int id, phone;
        for (String row : set) {
            String[] data = row.split(";");
            id = Integer.parseInt(data[0]);
            f_name = data[1];
            l_name = data[2];
            city = data[3];
            phone = Integer.parseInt(data[4]);
            res.add(new TestModel(id, f_name, l_name, city, phone));
        }
        return res;
    }

    public static void setEditableTest(TestModel editableTest) {
        EditableTest = editableTest;
    }

    public static TestModel getEditableTest() {
        return EditableTest;
    }

    public void EditButtonPress(ActionEvent actionEvent){
        setEditableTest(MainTable.getSelectionModel().getSelectedItem());
        ApplicationStart.getStage().setScene(ApplicationStart.getAddEditScene());
    }
}
