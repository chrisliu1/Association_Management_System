package management;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.stage.Stage;
/**
 *
 * @author lwjlwj
 */
public class App extends Application {
    final static String StudentNumber = "";
    @Override
    public void start(Stage stage) { 
        stage.setTitle("NJUBadminton Management System");
        WelcomePage page = new WelcomePage(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
