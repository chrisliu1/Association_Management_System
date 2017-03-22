/**   
* @Title: MemberPage.java 
* @Package management 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年3月12日 下午4:10:26 
* @version V1.0   
*/
package management;

import dao.MemberDao;
import dao.StaffDao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import managementclass.AssociationMember;
import managementclass.Staff;

/** 
* @ClassName: MemberPage 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年3月12日 下午4:10:26 
*  
*/
public class MemberPage {
    private Stage stage;
    private TableView<AssociationMember> membertable = new TableView<>();
    
    public MemberPage(Stage stage, String studentID)
    {
    	//Scene scene = new Scene(new Group());
        this.stage = stage;
        ObservableList<AssociationMember> memberlist = MemberDao.GetMemberList();
        
        TableColumn<AssociationMember, String> NameCol = new TableColumn<>("姓名");
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<AssociationMember, String> SubjectCol = new TableColumn<>("院系");
        SubjectCol.setMinWidth(200);
        SubjectCol.setCellValueFactory(new PropertyValueFactory<>("Subject"));
        
        TableColumn<AssociationMember, String> IDCol = new TableColumn<>("学号");
        IDCol.setMinWidth(100);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        
        TableColumn<AssociationMember, String> TelCol = new TableColumn<>("电话");
        TelCol.setMinWidth(200);
        TelCol.setCellValueFactory(new PropertyValueFactory<>("TelNumber"));
        
        TableColumn<AssociationMember, Integer> RemainTimeCol = new TableColumn<>("剩余次数");
        RemainTimeCol.setMinWidth(100);
        RemainTimeCol.setCellValueFactory(new PropertyValueFactory<>("RemainTime"));
        
        membertable.setItems(memberlist);
        membertable.getColumns().addAll(NameCol, SubjectCol, IDCol, TelCol, RemainTimeCol);
        
        membertable.getSelectionModel().selectedItemProperty().addListener(
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
        TextField telnumber = new TextField("电话");
        telnumber.setPromptText("电话");
        TextField remaintime = new TextField("剩余次数");
        remaintime.setPromptText("剩余次数");
        
        Button addbtn = new Button("新增");
        addbtn.setText("新增");
        addbtn.setOnAction((ActionEvent t) -> {
        	MemberDao.AddMember(username.getText(), studentnumber.getText(), telnumber.getText(), subject.getText(), Integer.valueOf(remaintime.getText()));
        });
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(username, subject, studentnumber, telnumber,remaintime, addbtn);
        
        GridPane grid = new GridPane();
        grid.setValignment(membertable, VPos.CENTER);
        grid.add(membertable, 0, 0);
        
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
