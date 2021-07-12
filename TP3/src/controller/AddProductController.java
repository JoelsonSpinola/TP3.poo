package controller;

import CLASS.Componentes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductController {
    
    @FXML
    private TextField txtProdName1;

    @FXML
    private TextField txtIDprod;

    @FXML
    private TextField txtProDesc;

    @FXML
    private TextField txtProQuan;
    
    @FXML
    private TextField txtProPric;

    @FXML
    private TextField txtProOri;

    @FXML
    private Button btAddPro;

    @FXML
    private Button btCancelPro;

    @FXML
    public void AddProduct(ActionEvent event) 
    {
        String nome = txtProdName1.getText();
        String code = txtIDprod.getText();
        String Desc = txtProDesc.getText();
        String Quantidade = txtProQuan.getText();
        String price = txtProPric.getText();
        String orig=txtProOri.getText();

        Componentes user = new Componentes(Integer.parseInt(code),nome,Desc,Integer.parseInt(Quantidade),Integer.parseInt(price),orig);

        txtProdName1.setText("");
        txtIDprod.setText("");
        txtProDesc.setText("");
        txtProQuan.setText("");
        txtProPric.setText("");
        txtProOri.setText("");
try {
    user.AddMaisComponentes();  
} catch (Exception e) {
    //TODO: handle exception
} 
    }

    @FXML
    public void CancelProductAction(ActionEvent event) 
    {
        Stage stage = (Stage)btCancelPro.getScene().getWindow();
        stage.close();
    }
}
