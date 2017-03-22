/**   
* @Title: StaffPage.java 
* @Package management 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年1月25日 上午10:36:50 
* @version V1.0   
*/
package management;

import dao.StaffDao;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import managementclass.Staff;

public class StaffPage {
    private Stage stage;
    private TableView<Staff> stafftable = new TableView<>();

	public StaffPage(Stage stage, String position, String studentID)
    {
    	//Scene scene = new Scene(new Group());
        this.stage = stage;
        ObservableList<Staff> stafflist = StaffDao.GetStaffList(position);
        
        TableColumn<Staff, String> NameCol = new TableColumn<>("姓名");
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Staff, String> SubjectCol = new TableColumn<>("院系");
        SubjectCol.setMinWidth(200);
        SubjectCol.setCellValueFactory(new PropertyValueFactory<>("Subject"));
        
        TableColumn<Staff, String> IDCol = new TableColumn<>("学号");
        IDCol.setMinWidth(100);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        
        TableColumn<Staff, String> PositionCol = new TableColumn<>("职位");
        PositionCol.setMinWidth(100);
        PositionCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        TableColumn<Staff, String> TelCol = new TableColumn<>("电话");
        TelCol.setMinWidth(200);
        TelCol.setCellValueFactory(new PropertyValueFactory<>("TelNumber"));
        
        stafftable.setItems(stafflist);
        stafftable.getColumns().addAll(NameCol, SubjectCol, IDCol, PositionCol, TelCol);
        
        stafftable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> new ChangePersonalInfoPage(stage, new Stage(), newValue.getStudentID()));
        
        /*VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(stafftable);*/
        
        TextField username = new TextField("姓名");
        username.setPromptText("姓名");
        TextField subject = new TextField("院系");
        subject.setPromptText("院系");
        TextField studentnumber = new TextField("学号");
        studentnumber.setPromptText("学号");
        TextField position2 = new TextField("职位");
        position2.setPromptText("职位");
        TextField telnumber = new TextField("电话");
        telnumber.setPromptText("电话");
        
        Button addbtn = new Button("新增");
        addbtn.setText("新增");
        addbtn.setOnAction((ActionEvent t) -> {
        	StaffDao.AddStaff(username.getText(), username.getText(), position2.getText(), studentnumber.getText(), telnumber.getText(), subject.getText());
        });
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(username, subject, studentnumber, position2, telnumber, addbtn);
        
        GridPane grid = new GridPane();
        grid.setValignment(stafftable, VPos.CENTER);
        grid.add(stafftable, 0, 0);
        
        RowConstraints all = new RowConstraints();
        all.setPercentHeight(100);
        all.setValignment(VPos.CENTER);
        grid.getRowConstraints().addAll(all);
        ColumnConstraints all2 = new ColumnConstraints();
        all2.setPercentWidth(100);
        all2.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().addAll(all2);
        
        BorderPane layout = new BorderPane();
        layout.setCenter(grid);
        
        MainMenu mainmenu = new MainMenu(stage, studentID);
        MenuBar menu = mainmenu.GetMenu();
        layout.setTop(menu);
        layout.setBottom(hbox);
    
        //((Group) scene.getRoot()).getChildren().addAll(grid);
        
        stage.setScene(new Scene(layout, 600, 400));
        stage.show();
    }
}
