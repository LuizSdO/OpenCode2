package br.com.fiap.opencode.model;

public class EditarCodigo {
    private int idportfolio;
    private String tituloCodigo;
    public EditarCodigo(int idportfolio, String tituloCodigo) {
        this.idportfolio = idportfolio;
        this.tituloCodigo = tituloCodigo;
    }
    public int getIdportfolio() {
        return idportfolio;
    }
    public void setIdportfolio(int idportfolio) {
        this.idportfolio = idportfolio;
    }
    public String getTituloCodigo() {
        return tituloCodigo;
    }
    public void setTituloCodigo(String tituloCodigo) {
        this.tituloCodigo = tituloCodigo;
    }
    @Override
    public String toString() {
        return "EditarCodigo [idportfolio=" + idportfolio + ", tituloCodigo=" + tituloCodigo + "]";
    }
    
}
