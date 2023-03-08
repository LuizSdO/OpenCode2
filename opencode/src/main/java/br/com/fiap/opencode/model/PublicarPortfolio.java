package br.com.fiap.opencode.model;

public class PublicarPortfolio {
    private int idusuario;
    private String nomeUsuario;
    private int idportfolio;
    private String nomePortfolio;
    private String senhaUsuario;
    public PublicarPortfolio(int idusuario, String nomeUsuario, int idportfolio, String nomePortfolio,
            String senhaUsuario) {
        this.idusuario = idusuario;
        this.nomeUsuario = nomeUsuario;
        this.idportfolio = idportfolio;
        this.nomePortfolio = nomePortfolio;
        this.senhaUsuario = senhaUsuario;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public int getIdportfolio() {
        return idportfolio;
    }
    public void setIdportfolio(int idportfolio) {
        this.idportfolio = idportfolio;
    }
    public String getNomePortfolio() {
        return nomePortfolio;
    }
    public void setNomePortfolio(String nomePortfolio) {
        this.nomePortfolio = nomePortfolio;
    }
    public String getSenhaUsuario() {
        return senhaUsuario;
    }
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    @Override
    public String toString() {
        return "PublicarPortfolio [idusuario=" + idusuario + ", nomeUsuario=" + nomeUsuario + ", idportfolio="
                + idportfolio + ", nomePortfolio=" + nomePortfolio + ", senhaUsuario=" + senhaUsuario + "]";
    }
    
}
