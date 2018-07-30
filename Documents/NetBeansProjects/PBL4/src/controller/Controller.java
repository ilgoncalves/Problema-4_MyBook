package controller;

import exception.DuplicateKeyException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import javafx.scene.image.Image;
import model.*;
import util.AdjMapGraph;

/**
 * Classe do Controller geral que guarda a referencia do grafo
 *
 * @author Igor Gonçalves
 *
 */
public class Controller {

    private AdjMapGraph<Usuario> usuarios = new AdjMapGraph<>();

    public AdjMapGraph<Usuario> getUsuarios() {
        return usuarios;
    }

    public Controller() {

    }

    /**
     * Metodo para inserir um usuario no grafo
     *
     * @param login login do Usuario
     * @param password senha do Usuario
     * @param nome Nome do Usuario
     * @param email email do Usuario
     * @param nascimento Data de nascimento do Usuario
     * @param endereço endereço do Usuario
     * @param telefone telefone do Usuario
     * @param foto foto do Usuario
     * @throws DuplicateKeyException
     */
    public void cadastroUsuario(String login, String password, String nome,
            String email, String nascimento, String endereço, String telefone, Image foto) throws DuplicateKeyException {
        Usuario usuario = new Usuario(login, password, nome, email, nascimento, endereço, telefone, foto);

        try {
            usuarios.addVertice(usuario);
        } catch (DuplicateKeyException e) {
            System.err.println("Já existe um usuario com este login ou com esse email");
        }
    }

    /**
     * Verifica se o usuario existe na HashMap
     *
     * @param email passa um email
     * @return o usuario que contem aquele determinado email
     */
    public Usuario verificarLogin(String email) {
        return (Usuario) usuarios.getVertices().get(email);
    }

    public void printar() {//Debug
        Iterator it = (Iterator) usuarios.usuarios();
        while (it.hasNext()) {
            System.out.println(((Usuario) it.next()).toString());
        }
    }

    /**
     * Metodo para buscar usuario no Set que guarda todos os usarios da rede
     *
     * @param nomeAComparar
     * @return um Set
     */
    public Set<Usuario> buscarUsuarios(String nomeAComparar) {
        Set<Usuario> users = this.usuarios.getAdjacencias().keySet();
        Set<Usuario> userMesmoNome = new HashSet<>();
        for (Usuario u : users) {
            String nomeDoUsuario = u.getNome().toLowerCase();
            nomeAComparar = nomeAComparar.toLowerCase();
            if (nomeDoUsuario.contains(nomeAComparar)) {
                userMesmoNome.add(u);
            }
        }
        return userMesmoNome;
    }
}
