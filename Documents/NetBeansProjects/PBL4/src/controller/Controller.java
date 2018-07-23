package controller;

import exception.DuplicateKeyException;
import java.util.Iterator;
import java.util.LinkedList;
import javafx.scene.image.Image;
import model.*;
import util.AdjMapGraph;

/**
 *
 * @author Igor Gonçalves
 *
 */
public class Controller {

    private AdjMapGraph<Usuario> usuarios = new AdjMapGraph<>();

    public Controller() {

    }

    public void cadastroUsuario(String login, String password, String nome,
            String email, String nascimento, String endereço, String telefone, Image foto) throws DuplicateKeyException {
        Usuario usuario = new Usuario(login, password, nome, email, nascimento, endereço, telefone, foto);

        try {
            usuarios.addVertice(usuario);
        } catch (DuplicateKeyException e) {
            System.err.println("Já existe um usuario com este login ou com esse email");
        }
    }

    public Usuario verificarLogin(String email) {
        return (Usuario) usuarios.getVertices().get(email);
    }

    public void printar() {//Debug
        Iterator it = (Iterator) usuarios.usuarios();
        while (it.hasNext()) {
            System.out.println(((Usuario) it.next()).toString());
        }
    }

}
