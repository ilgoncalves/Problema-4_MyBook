package controller;

import exception.DuplicateKeyException;
import java.io.File;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Usuario;
import view.Main;

public class cadastroController {

    private Controller ctr = Main.getCtr();
    private Image imagem;

    @FXML
    private ImageView imgPerfil;
    @FXML
    private PasswordField password;

    @FXML
    private TextField telefone;

    @FXML
    private TextField nascimento;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField endereço;

    @FXML
    private TextField nome;

    @FXML
    private TextField userName;

    @FXML
    private Button btn;

    @FXML
    private TextField email;

    @FXML
    void cadastroBotao(ActionEvent event) throws DuplicateKeyException {
        btn.setEffect(null);
        Image img = imgPerfil.getImage();
        ctr.cadastroUsuario(userName.getText(), password.getText(), nome.getText(), email.getText(),
                nascimento.getText(), endereço.getText(), telefone.getText(), img);
        userName.setText("");
        password.setText("");
        nome.setText("");
        email.setText("");
        nascimento.setText("");
        endereço.setText("");
        telefone.setText("");
        System.out.println("");
        System.out.println("");

        Main.changeScreen("login");
        File file = new File("C:\\Users\\1513 IRON\\Documents\\NetBeansProjects\\PBL4\\src\\imagens\\user.png");
        imgPerfil.setImage(new Image(file.toURI().toString()));
    }

    @FXML
    void procurarImg(ActionEvent event) {
        System.out.println("as");
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Escolhendo arquivo");
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        imagem = new Image(file.toURI().toString());
        imgPerfil.setImage(imagem);

    }

    @FXML
    void VoltarMenu(ActionEvent event) {
        Main.changeScreen("login");
    }

}