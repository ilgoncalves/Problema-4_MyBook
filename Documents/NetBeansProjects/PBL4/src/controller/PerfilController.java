package controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
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

    private Usuario userAtual;

    public void iniciar() {
        System.out.println(userAtual);
        imgPerfil.setImage(userAtual.getFoto());
        nomeUser.setText(userAtual.getNome());
    }

    public Usuario getUserAtual() {
        return userAtual;
    }

    public void setUserAtual(Usuario userAtual) {
        this.userAtual = userAtual;
    }

    @FXML
    void buscarPessoas(ActionEvent event) {
        String busca = buscador.getText();
        Set<Usuario> users = ctr.buscarUsuarios(busca);
        if (users.isEmpty()) {
            System.out.println("Nenhuma Usuario foi encontrado");
        } else {
            for (Usuario u : users) {
                System.out.println(u.getNome());
            }
        }
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
