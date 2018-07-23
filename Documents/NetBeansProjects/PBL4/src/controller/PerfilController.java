package controller;

import com.sun.media.sound.EmergencySoundbank;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.Main;

/**
 * FXML Controller class
 *
 * @author igor
 */
public class PerfilController implements Initializable {

    private Controller ctr = Main.getCtr(); //Controller Geral

    @FXML
    private TextField buscador;

    @FXML
    private ImageView imgPerfil;

    @FXML
    private Label nomeUser;

    private static Usuario userAtual;

//    private static PerfilController controler;
//    private PerfilController() {
//
//    }
//    public static PerfilController getInstace() {
//        if (controler == null) {
//            controler = new PerfilController();
//        }
//        return controler;
//    }
    public static Usuario getUserAtual() {
        return userAtual;
    }

    public static void setUserAtual(Usuario userAtual) {
        PerfilController.userAtual = userAtual;
    }

//Metodo citado nos comentario do loginControler
//    public static void iniciar() {
//        imgPerfil.setImage(userAtual.getFoto());
//        nomeUser.setText(userAtual.getNome());
//    }
    @FXML
    void buscarPessoas(ActionEvent event) {

    }

    @FXML
    void sair(ActionEvent event) {
        Main.changeScreen("login");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
