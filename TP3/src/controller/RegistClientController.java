package controller;

import java.net.URL;
import java.util.ResourceBundle;

import CLASS.Cliente;
import CLASS.IlhaResidente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistClientController implements Initializable
{
    @FXML
    private TextField txtCliName;
    
    @FXML 
    TextField txtCliNif;
    
    @FXML
    TextField txtCliID;

    @FXML
    private ComboBox txtCompoCli;

    @FXML
    private Button btRegCli;

    @FXML
    private Button btRegCancele;

    @FXML
    String[] ilhasderesidencia={"SA","SV","SN","SL","BV","MI","ST","FG","BR"};

    @FXML
    public void createClientAction(ActionEvent event) 
    {
        IlhaResidente ilha = IlhaResidente.valueOf(txtCompoCli.getValue().toString());
        String nome = txtCliName.getText();
        String nif = txtCliNif.getText();
        String id=txtCliID.getText();

        Cliente user = new Cliente(ilha, Integer.parseInt(id), Integer.parseInt(nif), nome);
        txtCliName.setText("");
        txtCliNif.setText("");
        txtCliID.setText("");
try {
    user.SalvarCliente();     
} catch (Exception e) {
    //TODO: handle exception
}

}

    @FXML
    public void cancelCliAction(ActionEvent event) 
    {
        Stage stage = (Stage) btRegCancele.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
       String nomeArquivo[] = location.toString().split("/");

       if(nomeArquivo[nomeArquivo.length-1].equals("RegistClient.fxml"))
       {
        txtCompoCli.setValue("Resident Island");
        txtCompoCli.getItems().addAll(ilhasderesidencia);
       }
        
    }
}
