package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import CLASS.Componentes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Controller implements Initializable{
    
    @FXML/*Home page */
    Button homepage;

    @FXML
    private ComboBox<String> ListaCompo;
    @FXML
    private TextField txtLogName;

    @FXML
    private TextField txtLogPass;

    @FXML
    private Button btLogin1;

    ArrayList<String> COmpoList=new ArrayList<>();
    @FXML
    public void HomePage() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..fxml/home.fxlm"));
        Parent root = loader.load();
        Stage window = (Stage) homepage.getScene().getWindow();
        window.setScene(new Scene(root));
     
    }
    //end home page call

    @FXML
    private MenuItem createFun;
    
    //create user 
    @FXML/*Create user*/


    public void initMenuAction(ActionEvent event) 
    {
        
        
        try {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/createuser.fxml"));
            Parent root = loader.load(); 

            Scene scene= new Scene(root);

        

            primaryStage.setTitle("Create User");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();    

        } catch (Exception e) {
            //TODO: handle exception
        }
    }    
        
        @FXML/*ADD product*/


    public void ADDmOreProduc(ActionEvent event) 
    {
        try {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/addproduct.fxml"));
            Parent root = loader.load(); 

            Scene scene= new Scene(root);

        

            primaryStage.setTitle("ADD Product");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show(); 

        } catch (Exception e) {
            //TODO: handle exception
        }
    }

        public void ADDClient(ActionEvent event) 
        {
            try {
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/RegistClient.fxml"));
                Parent root = loader.load(); 
    
                Scene scene= new Scene(root);
    
            
    
                primaryStage.setTitle("Regist Client");
                primaryStage.setResizable(false);
                primaryStage.setScene(scene);
                primaryStage.show(); 
    
            } catch (Exception e) {
                //TODO: handle exception
            }

    }

    public void HelpAction(ActionEvent event) 
        {
        
            try {
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/Help.fxml"));
                Parent root = loader.load(); 
    
                Scene scene= new Scene(root);
    
            
    
                primaryStage.setTitle("Help Question");
                primaryStage.setResizable(false);
                primaryStage.setScene(scene);
                primaryStage.show(); 
    
            } catch (Exception e) {
                //TODO: handle exception
            }

    }

    //Enviar pagina de login
    public void MakeLogin(ActionEvent event) 
    {
    
        try {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/login.fxml"));
            Parent root = loader.load(); 

            Scene scene= new Scene(root);

        

            primaryStage.setTitle("Login");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show(); 

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    //verificar e enviar pagina de sell
   
    private void MudaPagina(String path,Button btn) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
            Stage window = (Stage) btn.getScene().getWindow();
            window.setScene(new Scene(root));
    }
    @FXML
    private void Averiguacao() throws IOException {
        if (txtLogName.getText().toString().equals("Paulo") && txtLogPass.getText().toString().equals("1234")) {
            MudaPagina("../fxml/open.fxml",btLogin1);
            
        }
    }

    //carregar array e apresentar na tela
    public void getallName() throws IOException {
        String Id_componente;
        String Nome_componentes;
        String Descricao;
        String Quantidade;
        String Preco;
        String Origem;
        String total;
        String file = "Componentes.csv";
        List<String[]> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < content.size(); i++) {
            Id_componente = content.get(i)[0];// 
            Nome_componentes= content.get(i)[1];// 
            Descricao= content.get(i)[2];
            Quantidade=content.get(i)[3];
            Preco=content.get(i)[4];
            Origem=content.get(i)[5];// 
            total = Id_componente+" "+Nome_componentes+" "+Descricao+" "+Quantidade+" "+Preco+" "+Origem;
            COmpoList.add(total);
        }
        }

  

@Override
public void initialize(URL location, ResourceBundle resources) {
// TODO Auto-generated method stub
String[] filename = location.toString().split("/");
System.out.println(location.toString());


if(filename[filename.length - 1].toString().equals("open.fxml")){
    try {
        getallName();
    } catch (IOException e) {
        
        e.printStackTrace();
    }
    ListaCompo.setValue("Clica para procurar Componentes");
    ListaCompo.getItems().addAll((COmpoList));
}
    
}
}

