package view;

import controller.Controller;
import exception.DuplicateKeyException;
import java.io.File;
import javafx.scene.image.Image;
import model.Usuario;

/**
 * Classe para pre cadrastrar usuario na rede social
 *
 * @author 1513 IRON
 */
public class AutoCadastro {

    private Controller ctr;

    public static void carregaUsuarios(Controller ctr) throws DuplicateKeyException {
        File file = new File("imagens/user.png");
        Image img = new Image(file.toURI().toString());
        File file2 = new File("imagens/igor.png");
        File file3 = new File("imagens/igor2.jpg");
        File file4 = new File("imagens/igor3.jpg");
        File file5 = new File("imagens/gui.png");
        File file6 = new File("imagens/otavio.png");
        File file7 = new File("imagens/gilcimito.png");

        Image imgMito = new Image(file7.toURI().toString());
        Image imgOtavio = new Image(file6.toURI().toString());
        Image imgGui = new Image(file5.toURI().toString());
        Image imgIgor3 = new Image(file4.toURI().toString());
        Image imgIgor2 = new Image(file3.toURI().toString());
        Image imgIgor = new Image(file2.toURI().toString());
        ctr.cadastroUsuario("iguinho32", "123", "Igor Almeida junior", "junior32@hotmail.com", "28/04/1994", "Rua Prof. Thereza Cunha", "(75)99212-1898", imgIgor3);
        ctr.cadastroUsuario("riosgui", "123", "Guilherme Santana Rios", "riosgui@hotmail.com", "23/03/1999", "Rua Prof. Thereza Cunha", "(75)99225-1779", imgGui);
        ctr.cadastroUsuario("tata", "123", "Otavio Lima Gonçalves", "otavio-lima@hotmail.com", "06/10/2000", "Rua Prof. Thereza Cunha", "(75)99164-4178", imgOtavio);
        ctr.cadastroUsuario("gilcimito", "123", "Gilcimito Deuscreto", "discreto@hotmail.com", "04/01/1980", "Rua discreta", "(75)99985-1873", imgMito);
        ctr.cadastroUsuario("user5", "123", "User 5", "user5@hotmail.com", "05/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user6", "123", "User 6", "user6@hotmail.com", "06/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user7", "123", "User 7", "user7@hotmail.com", "07/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("user8", "123", "User 8", "user8@hotmail.com", "08/01/2018", "Rua Prof. Thereza Cunha", "(75)99213-1578", img);
        ctr.cadastroUsuario("iguinho", "123", "Igor José dos Santos", "joseigor@hotmail.com", "09/01/1996", "Rua Prof. Thereza Cunha", "(75)99213-1578", imgIgor2);
        ctr.cadastroUsuario("igorLg", "123", "Igor Lima Gonçalves", "lima-igor@hotmail.com",
                "17/09/1998", "Rua Pergentino Dultra", "(75)99251-1349", imgIgor);

        Usuario igor = (Usuario) ctr.getUsuarios().getVertices().get("lima-igor@hotmail.com");
        Usuario igor2 = (Usuario) ctr.getUsuarios().getVertices().get("joseigor@hotmail.com");
        Usuario igor3 = (Usuario) ctr.getUsuarios().getVertices().get("junior32@hotmail.com");
        Usuario gilcimito = (Usuario) ctr.getUsuarios().getVertices().get("discreto@hotmail.com");
        Usuario otavio = (Usuario) ctr.getUsuarios().getVertices().get("otavio-lima@hotmail.com");

        ctr.getUsuarios().addAresta(igor, otavio, 0);
        ctr.getUsuarios().addAresta(igor, igor2, 0);
        ctr.getUsuarios().addAresta(igor, igor3, 0);
        ctr.getUsuarios().addAresta(igor, gilcimito, 0);
        ctr.getUsuarios().addAresta(otavio, igor2, 0);
        ctr.getUsuarios().addAresta(otavio, gilcimito, 0);
        ctr.getUsuarios().addAresta(otavio, igor3, 0);
        ctr.getUsuarios().addAresta(gilcimito, igor3, 0);
        ctr.getUsuarios().addAresta(gilcimito, igor2, 0);

    }

}
