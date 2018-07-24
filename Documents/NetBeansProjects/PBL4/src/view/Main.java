package view;

import controller.Controller;
import controller.PerfilController;
import java.io.File;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Igor Gonçalves
 */
public class Main extends Application {

    private static Controller ctr = new Controller();
    private static Stage myStage;
    private static Scene login;
    private static Scene cadastrar;
    private static Scene perfil;
    private static PerfilController ctrPerfil;

    @Override
    public void start(Stage stage) throws Exception {
        myStage = stage;
        File file = new File("C:\\Users\\1513 IRON\\Documents\\NetBeansProjects\\PBL4\\src\\imagens\\icon.png");
        Image icon = new Image(file.toURI().toString());
        stage.getIcons().add(icon);
        stage.setTitle("MyBook");
        AutoCadastro.carregaUsuarios(ctr);

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login.fxml"));
        login = new Scene(fxmlLogin);
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
        cadastrar = new Scene(fxmlCadastro);

        FXMLLoader fx = new FXMLLoader(getClass().getResource("Perfil.fxml"));
        Parent fxmlPerfil = fx.load();
        ctrPerfil = fx.getController();
        perfil = new Scene(fxmlPerfil);

        stage.setScene(login);
        stage.show();
    }

    public static PerfilController getCtrPerfil() {
        return ctrPerfil;
    }

    public static void changeScreen(String scr) {
        switch (scr) {
            case "login":
                myStage.setScene(login);
                break;
            case "cadastrar":
                myStage.setScene(cadastrar);
                break;
            case "perfil":
                myStage.setScene(perfil);
                break;
        }
    }

    public static Controller getCtr() {
        return ctr;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
