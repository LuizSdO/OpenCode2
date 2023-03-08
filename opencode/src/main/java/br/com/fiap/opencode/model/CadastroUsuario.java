package br.com.fiap.opencode.model;

public class CadastroUsuario {
    private String email;
    private String senha;
    private String nome;


    public CadastroUsuario(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CadastroUsuario [email=" + email + ", senha=" + senha + ", nome=" + nome + "]";
    }


}
