package controller;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.io.IOException;

public class Controller {

    @FXML
    private Button ask_command;

    @FXML
    private Button ask_account;

    @FXML
    private Button ask_connect;

    @FXML
    private Button ask_back;

    @FXML
    private Button validateLogin;

    @FXML
    private Group pizza_icon;

    @FXML
    private Button manage_mode;



    
    @FXML
    public void setScene_list() throws Exception{

        changeScene(getScene(),"/View/pizz_display.fxml");
        
    }


    public Scene getScene() {
        if(ask_command != null)
            return ask_command.getScene();
        else if(ask_account != null)
            return ask_account.getScene();
        else if(ask_connect != null)
            return ask_connect.getScene();
        else if(ask_back != null)
            return ask_back.getScene();
        else if(validateLogin != null)
            return validateLogin.getScene();
        else if(pizza_icon != null)
            return pizza_icon.getScene();
        else
            return null;
    }

    @FXML
    public void setScene_account() throws Exception {

        changeScene(getScene(),"/View/account.fxml");

    }

    @FXML
    public void setScene_signin() throws Exception {

        changeScene(getScene(),"/View/signin.fxml");

    }

    @FXML
    public void setScene_main() throws Exception {

        changeScene(getScene(), "/View/main.fxml");

    }

   @FXML
    public void setScene_stats() throws Exception {

        changeScene(getScene(), "/View/stats.fxml");

    }

    static protected void changeScene(Scene scene,String newScene) throws IOException {
    	Parent loader  = new FXMLLoader(Controller.class.getResource(newScene)).load();
        scene.setRoot(loader);
	}

	@FXML
    public void pizzaClicked(){


        Animation animation = new Transition() {
            int i = 1;
            {
                setCycleDuration(Duration.millis(1000));
            }

            @Override
            protected void interpolate(double frac) {
                pizza_icon.setRotate(i*5.0);
                i++;
            }
        };
        animation.play();

    }
    
    @FXML
    public void setScene_menu() throws IOException{

        changeScene(getScene(),"/View/menu.fxml");
    	
    	
    }



}
