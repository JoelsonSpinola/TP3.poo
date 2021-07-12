package controller;

import CLASS.help;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelpController {
   
    @FXML
    private TextField txtHelp;
    
    @FXML
    private Button btSub;

    @FXML
    public void ADDQUESTHELP(ActionEvent event) 
    {
        String questao =txtHelp.getText();

        help user = new help(questao);
    try {
        user.SalvarHelp();     
    } catch (Exception e) {
        //TODO: handle exception
    }
    }
}