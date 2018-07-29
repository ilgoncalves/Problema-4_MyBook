package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Usuario;

public class UsuarioListViewCell extends ListCell<Usuario> {

    @FXML
    private Label nomeDoUsuario;

    @FXML
    private ImageView fotoDoUsuario;
    @FXML
    private GridPane gridPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Usuario usuario, boolean empty) {
        super.updateItem(usuario, empty);
        if (empty || usuario == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/view/ListCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    System.out.println("Algo de errado");
                }

            }
            nomeDoUsuario.setText(usuario.getNome());
            fotoDoUsuario.setImage(usuario.getFoto());
        }
        setText(null);
        setGraphic(gridPane);
    }

}
