package view;

import controller.Controller;
import exception.DuplicateKeyException;
import java.io.File;
import javafx.scene.image.Image;
import model.Usuario;

public class AutoCadastro {

    private Controller ctr;

    public AutoCadastro(Controller ctr) {

    }

    public static void carregaUsuarios(Controller ctr) throws DuplicateKeyException {
        File file = new File("C:\\Users\\1513 IRON\\Documents\\NetBeansProjects\\PBL4\\src\\imagens\\user.png");
        Image img = new Image(file.toURI().toString());
        File file2 = new File("C:\\Users\\1513 IRON\\Documents\\NetBeansProjects\\PBL4\\src\\imagens\\igor.png");
        Image imgIgor = new Image(file2.toURI().toString());
        ctr.cadastroUsuario("user1", "123", "User 1", "user1@hotmail.com", "01/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user2", "123", "User 2", "user2@hotmail.com", "02/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user3", "123", "User 3", "user3@hotmail.com", "03/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user4", "123", "User 4", "user4@hotmail.com", "04/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user5", "123", "User 5", "user5@hotmail.com", "05/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user6", "123", "User 6", "user6@hotmail.com", "06/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user7", "123", "User 7", "user7@hotmail.com", "07/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user8", "123", "User 8", "user8@hotmail.com", "08/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user9", "123", "User 9", "user9@hotmail.com", "09/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("igorLg", "123", "Igor Lima Gonçalves", "lima-igor@hotmail.com",
                "17/09/1998", "Rua Pergentino Dultra 201", "(75)99251-1349", imgIgor);
    }

}
