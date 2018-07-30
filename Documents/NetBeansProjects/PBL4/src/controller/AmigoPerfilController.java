package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.Main;

/**
 * Classe controladora da tela do perfil dos amigos ou da busca
 *
 * @author Igor Gonçalves
 */
public class AmigoPerfilController implements Initializable {

    private Controller ctr = Main.getCtr();
    @FXML
    private Label loginUser;

    @FXML
    private ListView<Usuario> listViewAmigos;

    @FXML
    private ImageView imgPerfil;

    @FXML
    private Label emailUser;

    @FXML
    private Label nascimentoUser;

    @FXML
    private Label telefoneUser;

    @FXML
    private Label nomeUser;

    @FXML
    private Button btnAdiciona;

    @FXML
    private ImageView logo;

    @FXML
    private Label enderecoUser;

    @FXML
    private Label nomeExibicao;

    @FXML
    private Label msgAmizade;

    @FXML
    private ListView<String> listViewMensagens;

    private Usuario usuarioPerfil;

    private Usuario usuarioLogado;

    /**
     * Setter do Usuario que está logado
     *
     * @param usuarioLogado
     */
    public void setUsuarioLogado(Usuario usuarioLogado) {

        this.usuarioLogado = usuarioLogado;
    }

    /**
     * Setter do usuario que está sendo visto o perfil
     *
     * @param usuarioPerfil
     */
    public void setUsuarioPerfil(Usuario usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    /**
     * Metodo para mudar de tela ao clicar no botao sair e ir voltar para tela
     * de login
     *
     * @param event
     */
    @FXML
    void sair(ActionEvent event) {
        Main.changeScreen("login");
    }

    /**
     * Metodo para Voltr para a tela de perfil do usuario logado
     *
     * @param event
     */
    @FXML
    void voltar(ActionEvent event) {
        Main.getCtrPerfil().exibeAmigos();
        Main.getCtrPerfil().verificaQntdAmigos();
        Main.changeScreen("perfil");
    }

    /**
     * Meto para trocar para a tela do pefil de um amigo ao clicar no botao
     *
     * @param event
     */
    @FXML
    void irParaAmigo(ActionEvent event) {
        Usuario amigo = listViewAmigos.getSelectionModel().getSelectedItem();
        this.setUsuarioLogado(usuarioLogado);
        this.setUsuarioPerfil(amigo);
        this.iniciar();
    }

    /**
     * metodo para adicionar o usuario que esta sendo exibido o perfil como
     * amigo do usuario logado
     *
     * @param event
     */
    @FXML
    void adicionar(ActionEvent event) {
        ctr.getUsuarios().addAresta(usuarioLogado, usuarioPerfil, 0);
        if (ctr.getUsuarios().getAdjacencias().get(usuarioPerfil).containsKey(usuarioLogado)) {
            btnAdiciona.setVisible(false);
            msgAmizade.setText(usuarioLogado.getNome() + ", Você e " + usuarioPerfil.getNome() + " são amigos");
        }
        exibeAmigos();
    }

    /**
     * Metodo auxiliar para printar as mensagens na listView de Mensagens
     *
     */
    public void exibeMesagens() {
        ObservableList list = FXCollections.observableArrayList(usuarioPerfil.getMensagens());
        listViewMensagens.setItems(list);
    }

    /**
     * Metodo auxiliar para printar os amigos de um usuario na listView de
     * amigos
     */
    public void exibeAmigos() {
        listViewAmigos.getItems().clear();
        listViewAmigos.setCellFactory(usuarioListView -> new UsuarioListViewCell());
        Set<Usuario> ks = ctr.getUsuarios().getAdjacencias().get(usuarioPerfil).keySet();
        for (Usuario u : ks) {

            listViewAmigos.getItems().add(u);
        }
    }

    /**
     * Metodo auxiliar para exibir todas as informações do usuario na tela de
     * perfil assim que a tela ficar visivel
     */
    void iniciar() {
        exibeMesagens();
        exibeAmigos();
        if (ctr.getUsuarios().getAdjacencias().get(usuarioPerfil).containsKey(usuarioLogado)) {
            btnAdiciona.setVisible(false);
            msgAmizade.setText(usuarioLogado.getNome() + ", Você e " + usuarioPerfil.getNome() + " são amigos");
        } else if (usuarioLogado.equals(usuarioPerfil)) {
            btnAdiciona.setVisible(false);
            msgAmizade.setText(usuarioLogado.getNome() + " ,este é o seu perfil");
        } else {
            btnAdiciona.setVisible(true);
            msgAmizade.setText("");
        }
        File file = new File("imagens/logo.jpg");
        logo.setImage(new Image(file.toURI().toString()));
        String[] nomeArray = usuarioPerfil.getNome().split(" ");
        String nome = nomeArray[0];
        nomeExibicao.setText(nome);
        imgPerfil.setImage(usuarioPerfil.getFoto());
        nomeUser.setText(usuarioPerfil.getNome());
        loginUser.setText(usuarioPerfil.getLogin());
        emailUser.setText(usuarioPerfil.getEmail());
        enderecoUser.setText(usuarioPerfil.getEndereço());
        nascimentoUser.setText(usuarioPerfil.getNascimento());
        telefoneUser.setText(usuarioPerfil.getTelefone());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
