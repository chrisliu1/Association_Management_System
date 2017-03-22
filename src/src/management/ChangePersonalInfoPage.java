/**   
* @Title: ChangePersonalInfoPage.java 
* @Package management 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年2月4日 上午10:21:41 
* @version V1.0   
*/
package management;

import dao.StaffDao;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import managementclass.Staff;

/** 
* @ClassName: ChangePersonalInfoPage 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年2月4日 上午10:21:41 
*  
*/
public class ChangePersonalInfoPage {
	public ChangePersonalInfoPage(Stage old_stage,Stage new_stage, String studentID)
	{
		GridPane grid = new GridPane();
		Staff user = StaffDao.GetStaff(studentID);
		
		Label username = new Label("姓名：");
		grid.add(username, 0, 0);
		TextField usernamefield = new TextField();
		usernamefield.setText(user.getName());
		grid.add(usernamefield, 1, 0);
		
		Label subject = new Label("院系：");
		grid.add(subject, 0, 1);
		TextField subjecttext = new TextField();
		subjecttext.setText(user.getSubject());
		grid.add(subjecttext, 1, 1);
		
		Label StudentID = new Label("学号：");
		grid.add(StudentID, 0, 2);
		TextField studentidtext = new TextField();
		studentidtext.setText(user.getStudentID());
		grid.add(studentidtext, 1, 2);
		
		Label position = new Label("职位："); 
		grid.add(position, 0, 3);
		TextField positionfield = new TextField();
		positionfield.setText(user.getStatus());
		grid.add(positionfield, 1, 3);
		
		Label password = new Label("密码：");
		TextField passwordtext = new TextField();
		passwordtext.setText(user.getPassword());
		grid.add(password, 0, 4);
		grid.add(passwordtext, 1, 4);
		
		Label telnumber = new Label("电话：");
		TextField telnumbertext = new TextField();
		telnumbertext.setText(user.getTelNumber());
		grid.add(telnumber, 0, 5);
		grid.add(telnumbertext, 1, 5);
		
		Button btn = new Button("修改");
		grid.add(btn, 0, 6);
		
		Scene scene = new Scene(grid);
		new_stage.setScene(scene);
		new_stage.show();
		btn.setOnAction((ActionEvent e) -> {
			StaffDao.UpdateStaff(usernamefield.getText(), passwordtext.getText(), positionfield.getText(), studentidtext.getText(), telnumbertext.getText(), subjecttext.getText());
			new_stage.close();
		});
	}
}
