package br.com.fiap.opencode.model;

public class ClonarPortfolio {
    private int idusuario;
    private int idportfolio;
    public ClonarPortfolio(int idusuario, int idportfolio) {
        this.idusuario = idusuario;
        this.idportfolio = idportfolio;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public int getIdportfolio() {
        return idportfolio;
    }
    public void setIdportfolio(int idportfolio) {
        this.idportfolio = idportfolio;
    }
    @Override
    public String toString() {
        return "ClonarPortfolio [idusuario=" + idusuario + ", idportfolio=" + idportfolio + "]";
    }
    
}
