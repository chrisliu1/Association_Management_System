/**   
* @Title: AddContributionPage.java 
* @Package management 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年2月15日 下午8:32:20 
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
* @ClassName: AddContributionPage 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年2月15日 下午8:32:20 
*  
*/
public class AddContributionPage {
	public AddContributionPage(Stage stage)
	{
		
		Label date = new Label("日期");
		TextField dateField = new TextField();
		
		Label id = new Label("学号");
		TextField idField = new TextField();
		
		Label content = new Label("内容");
		TextField contentField = new TextField();
		
		GridPane grid = new GridPane();
		grid.add(date, 0, 1);
		grid.add(dateField, 1, 1);
		grid.add(id, 0, 2);
		grid.add(idField, 1, 2);
		grid.add(content, 0, 3);
		grid.add(contentField, 0, 4);
		
		Button review = new Button("新增");
		grid.add(review, 1, 5);
		review.setOnAction((ActionEvent t) -> {
			AccountDao.AddContribution(idField.getText(), dateField.getText(), contentField.getText());
			stage.close();
		});
		
		stage.setScene(new Scene(grid, 300, 300));
		stage.show();
	}
}
