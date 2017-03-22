/**   
* @Title: BlancePage.java 
* @Package management 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wjliu1998@gmail.com
* @date 2017年2月19日 上午9:53:15 
* @version V1.0   
*/
package management;

import dao.AccountDao;
import dao.ItemDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import managementclass.Item;
import managementclass.StaffContribution;

/** 
* @ClassName: BlancePage 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wjliu1998@gmail.com
* @date 2017年2月19日 上午9:53:15 
*  
*/
public class BlancePage {
	@SuppressWarnings("unchecked")
	public BlancePage(Stage stage, String PersonalID)
	{
		BorderPane layout = new BorderPane();
		GridPane grid = new GridPane();
		TableView<Item> ItemTable = new TableView<>();
        ObservableList<Item> itemlist = ItemDao.GetItemList();
        ObservableList<String> itemNameList = ItemDao.GetItemNameList();
        
        ChoiceBox itemNamecb = new ChoiceBox();
        itemNamecb.setItems(itemNameList);
        
        //cb.getSelectionModel().getSelectedItem();
        ChoiceBox itemStatecb = new ChoiceBox();
        itemStatecb.setItems(FXCollections.observableArrayList("购入","售出"));
        
        TextField itemNumberText = new TextField();
        itemNumberText.setPromptText("输入桶数");
        
        Button btn = new Button("确定");
        btn.setOnAction((ActionEvent e) ->{
        	String itemName = (String) itemNamecb.getSelectionModel().getSelectedItem();
        	String itemState = (String) itemStatecb.getSelectionModel().getSelectedItem();
        	int itemNumber = Integer.valueOf(itemNumberText.getText());
        	if(itemState == "购入") ItemDao.UpdateItemState(itemName, itemNumber);
        	else					ItemDao.UpdateItemState(itemName, -itemNumber);
        });
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(itemNamecb, itemStatecb, itemNumberText, btn);
        
        TableColumn<Item, String> ItemnameCol = new TableColumn<>("名称");
        ItemnameCol.setMinWidth(100);
        ItemnameCol.setCellValueFactory(new PropertyValueFactory<>("itemname"));
        
        TableColumn<Item, Integer> CostCol = new TableColumn<>("进价");
        CostCol.setMinWidth(100);
        CostCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
        
        TableColumn<Item, Integer> PriceCol = new TableColumn<>("售价");
        PriceCol.setMinWidth(100);
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        TableColumn<Item, Integer> RemainCol = new TableColumn<>("剩余");
        RemainCol.setMinWidth(100);
        RemainCol.setCellValueFactory(new PropertyValueFactory<>("remainnumber"));
        
        ItemTable.setItems(itemlist);
        ItemTable.getColumns().addAll(ItemnameCol, CostCol, PriceCol, RemainCol);
        
        grid.setValignment(ItemTable, VPos.CENTER);
        grid.add(ItemTable, 0, 0);
        
        
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
        layout.setBottom(hbox);
        
        stage.setScene(new Scene(layout, 600, 400));
        stage.show();
	}
}
