/**   
* @Title: PersonalInfo.java 
* @Package management 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年1月30日 上午10:43:08 
* @version V1.0   
*/
package management;

import dao.StaffDao;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import managementclass.Staff;

/** 
* @ClassName: PersonalInfo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年1月30日 上午10:43:08 
*  
*/
public class PersonalInfoPage {
	public PersonalInfoPage(Stage stage, String studentID)
	{
		Staff staff = StaffDao.GetStaff(studentID);
		BorderPane border = new BorderPane();
		MainMenu mainmenu = new MainMenu(stage, studentID);
		MenuBar menu = mainmenu.GetMenu();
		GridPane grid = new GridPane();
		Label username = new Label("姓名：" + staff.getName());
		grid.add(username, 0, 0);
		
		Label subject = new Label("院系：" + staff.getSubject());
		grid.add(subject, 0, 1);
		
		Label StudentID = new Label("学号：" + staff.getStudentID());
		grid.add(StudentID, 0, 2);
		
		Label position = new Label("职位：" + staff.getStatus()); 
		grid.add(position, 0, 3);
		
		Label telnumber = new Label("电话：" + staff.getTelNumber());
		grid.add(telnumber, 0, 4);
		
		Button btn1 = new Button("修改");
		btn1.setOnAction((ActionEvent e) ->{
			new ChangePersonalInfoPage(stage, new Stage(), staff.getStudentID());
		});
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		hbox.getChildren().addAll(btn1);
		
		grid.add(hbox, 0, 5);
		
		border.setTop(menu);
		border.setCenter(grid);
		Scene scene = new Scene(border);
		stage.setScene(scene);
		stage.show();
	}
}
