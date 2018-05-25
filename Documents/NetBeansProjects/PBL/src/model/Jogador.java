package model;

public class Jogador {

    private String usuario;
    private String senha;
    private MaoDeCarta mao;

    public Jogador(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.mao = new MaoDeCarta();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public MaoDeCarta getMao() {
        return mao;
    }

    public void setMao(MaoDeCarta mao) {
        this.mao = mao;
    }

    @Override
    public String toString() {
        return this.usuario;
    }

}
