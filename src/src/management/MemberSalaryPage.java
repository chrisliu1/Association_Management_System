/**   
* @Title: MemberSalaryPage.java 
* @Package management 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年2月10日 上午11:16:49 
* @version V1.0   
*/
package management;

import dao.AccountDao;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import managementclass.Staff;
import managementclass.StaffContribution;

/** 
* @ClassName: MemberSalaryPage 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年2月10日 上午11:16:49 
*  
*/
public class MemberSalaryPage {
	public MemberSalaryPage(Stage stage, String PersonalID, String StudentID, String Date)
	{
		BorderPane layout = new BorderPane();
		TableView<StaffContribution> ContributionTable = new TableView<>();
        ObservableList<StaffContribution> stafflist = AccountDao.GetStaffContribution(StudentID, Date);
        
        TableColumn<StaffContribution, String> NameCol = new TableColumn<>("姓名");
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        
        TableColumn<StaffContribution, String> IDCol = new TableColumn<>("学号");
        IDCol.setMinWidth(100);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        
        TableColumn<StaffContribution, String> DateCol = new TableColumn<>("日期");
        DateCol.setMinWidth(100);
        DateCol.setCellValueFactory(new PropertyValueFactory<>("Date"));
        
        TableColumn<StaffContribution, String> ContributionCol = new TableColumn<>("经历");
        ContributionCol.setMinWidth(200);
        ContributionCol.setCellValueFactory(new PropertyValueFactory<>("Contribution"));
        
        ContributionTable.setItems(stafflist);
        ContributionTable.getColumns().addAll(NameCol, IDCol, DateCol, ContributionCol);
        ContributionTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> new ContributionPage(new Stage(), newValue));
        
        GridPane grid = new GridPane();
        grid.setValignment(ContributionTable, VPos.CENTER);
        grid.add(ContributionTable, 0, 0);
        
        Button addbtn = new Button("新增");
        addbtn.setOnAction((ActionEvent t) -> {
        	new AddContributionPage(new Stage());
        });
        
        
        RowConstraints all = new RowConstraints();
        all.setPercentHeight(100);
        all.setValignment(VPos.CENTER);
        grid.getRowConstraints().addAll(all);
        ColumnConstraints all2 = new ColumnConstraints();
        all2.setPercentWidth(100);
        all2.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().addAll(all2);
        
        layout.setCenter(grid);
        MainMenu mainmenu = new MainMenu(stage, PersonalID);
        MenuBar menu = mainmenu.GetMenu();
        layout.setTop(menu);
        //layout.setBottom(hbox);
        layout.setBottom(addbtn);
        
        stage.setScene(new Scene(layout, 600, 400));
        stage.show();
	}
}
