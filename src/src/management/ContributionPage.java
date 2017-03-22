/**   
* @Title: ContributionPage.java 
* @Package management 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年2月15日 下午3:51:43 
* @version V1.0   
*/
package management;

import dao.AccountDao;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import managementclass.StaffContribution;

/** 
* @ClassName: ContributionPage 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年2月15日 下午3:51:43 
*  
*/
public class ContributionPage {
	public ContributionPage(Stage stage, StaffContribution staffcontribution)
	{
		Label name = new Label("姓名");
		TextField nameField = new TextField();
		nameField.setText(staffcontribution.getName());
		
		Label date = new Label("日期");
		TextField dateField = new TextField();
		dateField.setText(staffcontribution.getDate());
		
		Label id = new Label("学号");
		TextField idField = new TextField();
		idField.setText(staffcontribution.getStudentID());
		
		Label content = new Label("内容");
		TextField contentField = new TextField();
		contentField.setText(staffcontribution.getContribution());
		
		GridPane grid = new GridPane();
		grid.add(name, 0, 0);
		grid.add(nameField, 1, 0);
		grid.add(date, 0, 1);
		grid.add(dateField, 1, 1);
		grid.add(id, 0, 2);
		grid.add(idField, 1, 2);
		grid.add(content, 0, 3);
		grid.add(contentField, 0, 4);
		
		Button review = new Button("修改");
		grid.add(review, 1, 5);
		review.setOnAction((ActionEvent t) -> {
			AccountDao.UpdateContribution(staffcontribution.getID(), idField.getText(), dateField.getText(), contentField.getText());
			stage.close();
		});
		
		stage.setScene(new Scene(grid, 300, 300));
		stage.show();
	}
}
