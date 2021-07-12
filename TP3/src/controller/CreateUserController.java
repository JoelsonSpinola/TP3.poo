package controller;

import java.net.URL;
import java.util.ResourceBundle;

import CLASS.Funcionario;
import CLASS.IlhaResidente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateUserController implements Initializable{
    
    @FXML
    private TextField txtNIF;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox txtResidencia;

    @FXML
    private Button btCreate;

    @FXML
    private Button btCancel;

    String[] ilhasderesidencia={"SA","SV","SN","SL","BV","MI","ST","FG","BR"};

    @FXML
    public void createUserAction(ActionEvent event) 
    {
        IlhaResidente ilha = IlhaResidente.valueOf(txtResidencia.getValue().toString());
        String nome = txtUser.getText();
        String nif = txtNIF.getText();
        String pass = txtPassword.getText();

        Funcionario user = new Funcionario(ilha, Integer.parseInt(pass) , Integer.parseInt(nif) , nome);
        txtUser.setText("");
        txtNIF.setText("");
        txtPassword.setText("");
try {
    user.SalvarFuncionario();     
} catch (Exception e) {
    //TODO: handle exception
}

}

    @FXML
    public void cancelUserAction(ActionEvent event) 
    {
        Stage stage = (Stage)btCancel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
       String nomeArquivo[] = location.toString().split("/");

       if(nomeArquivo[nomeArquivo.length-1].equals("createuser.fxml"))
       {
        txtResidencia.setValue("Resident Island");
        txtResidencia.getItems().addAll(ilhasderesidencia);
       }
        
    }
}
