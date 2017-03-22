/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;


import java.util.ArrayList;

import dao.StaffDao;

import management.MainMenu;
import managementclass.Staff;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
/**
 *
 * @author lwjlwj
 */
public class WelcomePage {
    private Stage stage;
    
    public WelcomePage(Stage stage)
    {
        this.stage = stage;
        stage.setWidth(500);
        stage.setHeight(500);
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid);
        //Image image = new Image(getClass().getResourceAsStream("resource/Welcome.jpg"));
        Label label = new Label();
        //label.setGraphic(new ImageView(image));
        
        
        /*HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        VBox vbox = new VBox();
        
        Text scenetitle = new Text("Welcome");
        Label userName = new Label("User Name:");
        TextField userTextField = new TextField();
        Label pw = new Label("Password:");
        PasswordField pwBox = new PasswordField();
        Button btn = new Button("Sign in");
        
        hbox1.setPadding(new Insets(10));
        hbox1.setSpacing(10);
        hbox1.getChildren().addAll(userName, userTextField);
        
        hbox2.setPadding(new Insets(10));
        hbox2.setSpacing(10);
        hbox2.getChildren().addAll(pw, pwBox);
        
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(scenetitle, hbox1, hbox2, btn); */
        
        GridPane grid2 = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 1, 0);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        btn.setOnAction((ActionEvent e) -> {
        	String username = userTextField.getText();
        	String password = pwBox.getText();
        	if(LoginCheck(username, password) == true)	
        	{
        		new PersonalInfoPage(stage, username);
        	}
        	else
        	{
        		Label WrongNumber = new Label("Wrong username or password");
        		grid.add(WrongNumber, 5, 1);
        	}
        });
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        //grid.add(label, 0, 0);
        // grid.add(grid2, 0, 1);
        
        //root.getChildren().add(label);
        //root.setAutoSizeChildren(true);
        stage.setScene(scene);
        stage.show();
    }
    
    public boolean LoginCheck(String username, String password)
    {
    	ObservableList<Staff> stafflist = StaffDao.GetStaffList(null);
    	boolean judge = false;
    	for(Staff person: stafflist)
    	{
    		if(person.getStudentID().equals(username) && person.getPassword().equals(password)) 
    		{
    			judge = true;
    			break;
    		}
    	}
    	return judge;
    }
}
