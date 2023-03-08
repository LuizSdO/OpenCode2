package br.com.fiap.opencode.model;

public class SalvarAlteracoes {
    private int idcodigo;
    private String nomeCodigo;
    private int idportfolio;
    public SalvarAlteracoes(int idcodigo, String nomeCodigo, int idportfolio) {
        this.idcodigo = idcodigo;
        this.nomeCodigo = nomeCodigo;
        this.idportfolio = idportfolio;
    }
    public int getIdcodigo() {
        return idcodigo;
    }
    public void setIdcodigo(int idcodigo) {
        this.idcodigo = idcodigo;
    }
    public String getNomeCodigo() {
        return nomeCodigo;
    }
    public void setNomeCodigo(String nomeCodigo) {
        this.nomeCodigo = nomeCodigo;
    }
    public int getIdportfolio() {
        return idportfolio;
    }
    public void setIdportfolio(int idportfolio) {
        this.idportfolio = idportfolio;
    }
    @Override
    public String toString() {
        return "SalvarAlteracoes [idcodigo=" + idcodigo + ", nomeCodigo=" + nomeCodigo + ", idportfolio=" + idportfolio
                + "]";
    }

    
}
