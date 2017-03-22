/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import management.StaffPage;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lwjlwj
 */
public class MainMenu {
    MenuBar menu;
    public MainMenu(Stage stage, String studentID)
    {
        MenuBar menubar = new MenuBar();
        
        Menu Member = new Menu("成员信息");
        MenuItem AllMember = new MenuItem("通讯录");
        AllMember.setOnAction((ActionEvent t) -> {
            new StaffPage(stage, null, studentID);
        });
        MenuItem PersonalAccount = new MenuItem("个人信息");
        PersonalAccount.setOnAction((ActionEvent t) ->{
                	new PersonalInfoPage(stage, studentID);
        });
        Member.getItems().addAll(AllMember, PersonalAccount);
        
        Menu Users = new Menu("管理会员");
        MenuItem member = new MenuItem("会员信息");
        member.setOnAction((ActionEvent t) -> {
        	new MemberPage(stage, studentID);
        });
        Users.getItems().addAll(member);

        Menu Account = new Menu("账目");
        MenuItem MemberSalary = new MenuItem("成员贡献");
        MemberSalary.setOnAction((ActionEvent t) ->{
        	new MemberSalaryPage(stage, studentID, null, null);
        });
        MenuItem Balance = new MenuItem("收支");
        Balance.setOnAction((ActionEvent t) ->{
        	new BlancePage(stage, studentID);
        });
        Account.getItems().addAll(MemberSalary, Balance);
        Menu Exit = new Menu("退出");
        
        MenuItem exitToWelcome = new MenuItem("重新登录");
        exitToWelcome.setOnAction((ActionEvent t) ->{
        	new WelcomePage(stage);
        });
        
        MenuItem exitApp = new MenuItem("退出系统");
        exitApp.setOnAction((ActionEvent t) -> {
        	System.exit(0);
        });
        Exit.getItems().addAll(exitToWelcome, exitApp);
        
        menubar.getMenus().addAll(Member, Users, Account, Exit);
        this.menu = menubar;
    }
    
    public MenuBar GetMenu()
    {
    	return this.menu;
    }
}
