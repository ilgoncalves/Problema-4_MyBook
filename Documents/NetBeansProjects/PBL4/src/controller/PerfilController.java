package controller;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Usuario;
import view.Main;

/**
 * Classe controladora da tela do perfil do usuario logado
 *
 * @author Igor Gonçalves
 */
public class PerfilController implements Initializable {

    private Controller ctr = Main.getCtr(); //Controller Geral
    private Usuario userAtual;

    @FXML
    private Button btnFecharBusca;

    @FXML
    private ListView<Usuario> listViewAmigos;

    @FXML
    private ListView<String> listViewMensagens;

    @FXML
    private Button btnIrPara;

    @FXML
    private TextArea campoMensagem;

    @FXML
    private ListView<Usuario> listViewBusca;

    @FXML
    private TextField buscador;

    @FXML
    private ImageView imgPerfil;

    @FXML
    private Label nomeUser;

    @FXML
    private Label loginUser;

    @FXML
    private ImageView logo;

    @FXML
    private Label qntdAmigos;

    @FXML
    private Label emailUser;

    @FXML
    private Label nomeExibicao;

    @FXML
    private Label nascimentoUser;

    @FXML
    private Label telefoneUser;

    @FXML
    private Label enderecoUser;

    private AmigoPerfilController control;

    private Scene cenaAmigoPerfil;
    private FXMLLoader amigoPefil;

    /**
     * Metodo auxiliar para exibir todas as informações do usuario na tela de
     * perfil assim que a tela ficar visivel
     *
     * @throws java.io.IOException
     */
    public void iniciar() throws IOException {
        exibeMesagens();
        exibeAmigos();
        verificaQntdAmigos();
        btnIrPara.setVisible(false);
        listViewBusca.setVisible(false);
        btnFecharBusca.setVisible(false);
        buscador.setText("");
        File file = new File("imagens/logo.jpg");
        logo.setImage(new Image(file.toURI().toString()));
        String[] nomeArray = userAtual.getNome().split(" ");
        String nome = nomeArray[0];
        nomeExibicao.setText(nome);
        imgPerfil.setImage(userAtual.getFoto());
        nomeUser.setText(userAtual.getNome());
        loginUser.setText(userAtual.getLogin());
        emailUser.setText(userAtual.getEmail());
        enderecoUser.setText(userAtual.getEndereço());
        nascimentoUser.setText(userAtual.getNascimento());
        telefoneUser.setText(userAtual.getTelefone());

        amigoPefil = new FXMLLoader(getClass().getResource("/view/AmigoPerfil.fxml"));
        Parent fxmlAmigoPerfil = amigoPefil.load();
        cenaAmigoPerfil = new Scene(fxmlAmigoPerfil);
        control = amigoPefil.getController();

    }

    /**
     * Calcula quantos amigos o usuario logado tem
     */
    public void verificaQntdAmigos() {
        if (ctr.getUsuarios().getAdjacentes(userAtual) == null) {
            qntdAmigos.setText("Você ainda não possui amigos");
        } else {
            qntdAmigos.setText("Você possui " + ctr.getUsuarios().getAdjacentes(userAtual).size() + " amigos");
        }

    }

    /**
     * Getter do usuario logado
     *
     * @return o usuario
     */
    public Usuario getUserAtual() {
        return userAtual;
    }

    /**
     * Setter do usuario logado
     *
     * @param userAtual
     */
    public void setUserAtual(Usuario userAtual) {
        this.userAtual = userAtual;
    }

    /**
     * Busca pessoa na rede Social através do nome
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void buscarPessoas(ActionEvent event) throws IOException {

        listViewBusca.getItems().clear();
        String busca = buscador.getText();

        Set<Usuario> users = ctr.buscarUsuarios(busca);

        if (users.isEmpty()) {
            System.out.println("Nenhum Usuario foi encontrado");
        } else if (busca.equals("")) {
            System.out.println("Digite alguma coisa para buscar");
        } else {
            listViewBusca.setVisible(true);
            btnFecharBusca.setVisible(true);
            btnIrPara.setVisible(true);

            listViewBusca.setCellFactory(usuarioListView -> new UsuarioListViewCell());
            for (Usuario u : users) {
                if (!u.equals(userAtual)) {
                    listViewBusca.getItems().add(u);
                }
            }
        }
    }

    /**
     * Metodo para ir para o perfil do usuario buscado
     *
     * @param event
     */
    @FXML
    void irPara(ActionEvent event) {
        Usuario user = listViewBusca.getSelectionModel().getSelectedItem();
        if (user == null) {
            return;
        }
//        System.out.println(user);

        control.setUsuarioLogado(userAtual);
        control.setUsuarioPerfil(user);
        control.iniciar();

        Main.setMyStage(cenaAmigoPerfil);
    }

    /**
     * Metodo para ir para o perfil do amigo selecionado
     *
     * @param event
     */
    @FXML
    void irParaAmigo(ActionEvent event) {
        Usuario amigo = listViewAmigos.getSelectionModel().getSelectedItem();
        if (amigo == null) {
            return;
        }
        control.setUsuarioLogado(userAtual);
        control.setUsuarioPerfil(amigo);
        control.iniciar();
        Main.setMyStage(cenaAmigoPerfil);
    }

    /**
     * Metodo para excluir uma mensagem seleciona
     *
     * @param event
     */
    @FXML
    void excluirMensagens(ActionEvent event) {
        String mensagem = listViewMensagens.getSelectionModel().getSelectedItem();
        if (mensagem == null) {
            return;
        }
        listViewMensagens.getItems().remove(mensagem);
        userAtual.getMensagens().remove(mensagem);
    }

    /**
     * Metodo para fechar o campo de busca ao clicar no botao
     *
     * @param event
     */
    @FXML
    void fecharBusca(ActionEvent event) {
        listViewBusca.setVisible(false);
        btnFecharBusca.setVisible(false);
        btnIrPara.setVisible(false);
    }

    /**
     * Metodo para publicar uma mensagem ao clicar no botao
     *
     * @param event
     */
    @FXML
    void publicarMensagem(ActionEvent event) {
        String msg = campoMensagem.getText();
        campoMensagem.setText("");
        userAtual.adicionaMensagem(msg);
        exibeMesagens();
    }

    /**
     * Metodo auxiliar para carregar as mensagens do usuario na listView de
     * mensagens
     */
    public void exibeMesagens() {
        ObservableList list = FXCollections.observableArrayList(userAtual.getMensagens());
        listViewMensagens.setItems(list);
    }

    /**
     * Metodo auxiliar para carregar os amigos do usuario na listView de amigos
     */
    public void exibeAmigos() {
        listViewAmigos.getItems().clear();
        listViewAmigos.setCellFactory(usuarioListView -> new UsuarioListViewCell());
        Set<Usuario> ks = ctr.getUsuarios().getAdjacencias().get(userAtual).keySet();
        for (Usuario u : ks) {
            listViewAmigos.getItems().add(u);
        }
    }

    /**
     * Metodo para trocar para a tela de login ao clicar no botao sair
     *
     * @param event
     */
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
