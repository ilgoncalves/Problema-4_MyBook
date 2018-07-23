package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.Main;

public class loginControler implements Initializable {

    private Controller ctr = Main.getCtr();

    @FXML
    private Label mensagemErro;

    @FXML
    private ImageView imgInicio;
    @FXML
    private PasswordField password;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField login;

    @FXML
    private Button cadastre;

    @FXML
    void cadastrese(ActionEvent event) {
        Main.changeScreen("cadastrar");
        mensagemErro.setText("");
        password.setText("");
        login.setText("");
    }

    @FXML
    void login(ActionEvent event) {
        Usuario user = ctr.verificarLogin(login.getText());
        if (login.getText().equals("") && password.getText().equals("")) {
            mensagemErro.setText("Você não digitou nada!");
        } else if (login.getText().equals("")) {
            mensagemErro.setText("Você não digitou seu email!");
        } else if (password.getText().equals("")) {
            mensagemErro.setText("Você não digitou sua senha!");
        } else {
            if (user != null) {
                if (user.getPassword().equals(password.getText())) {
                    System.out.println("Entrou no perfil");
                    System.out.println(user.toString());
                    //O problema é justamente aqui, quero passar esse user para a tela de perfil para que eu possa
                    //exibir as informações dele la.
                    //So que eu não posso instanciar um PerfilController aqui
                    //poq ele é iniciado la na classe main no metodo start.

//                    PerfilController.setUserAtual(user);
                    //Fazendo isso eu consigo passar o objeto para aquele controler la, mas não tem um metodo para exibir as informações
                    //ja tentei fazer criar um metodo estatico e iniciar aqui;
                    //Tipo assim:
//                      PerfilController.iniciar();
                    //mas eu não posso, pois como "userAtual" é estatico, mas os atributos do FXML não podem ser estaticos, ou seja
                    //não da para atribui-los à "userAtual", como foi tentado fazer la;
                    //Ja tentei o singleton tambem
//                    PerfilController ctrP = PerfilController.getInstace();
//                    ctrP.setUserAtual(user);
//                    ctrP.iniciar();
                    Main.changeScreen("perfil");
                    mensagemErro.setText("");
                } else {
                    mensagemErro.setText("Senha Incorreta");
                }
            } else {
                mensagemErro.setText("Usuario não foi encontrado");
            }
        }
        System.out.println("");
        System.out.println("");

        login.setText("");
        password.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("C:\\Users\\1513 IRON\\Documents\\NetBeansProjects\\PBL4\\src\\imagens\\icon.png");
        imgInicio.setImage(new Image(file.toURI().toString()));
    }

}