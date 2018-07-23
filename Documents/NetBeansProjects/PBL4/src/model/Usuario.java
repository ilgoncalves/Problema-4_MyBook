package model;

import java.util.Objects;
import javafx.scene.image.Image;

public class Usuario {

    private String login;
    private String password;
    private String nome;
    private String email;
    private String nascimento;
    private String endereço;
    private String telefone;

    private Image foto;

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Usuario(String login, String password, String nome, String email, String nascimento, String endereço, String telefone, Image foto) {
        this.login = login;
        this.password = password;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.endereço = endereço;
        this.telefone = telefone;
        this.foto = foto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.email.equals(((Usuario) obj).getEmail()) || this.login.equals(((Usuario) obj).login);
    }

    @Override
    public String toString() {
        return "Login: " + this.login + "\nEmail: " + this.email + "\nEndereço: " + this.endereço + "\nNome: "
                + this.nome + "\nNascimento: " + this.nascimento + "\nTelefone: " + this.telefone;
    }
}
