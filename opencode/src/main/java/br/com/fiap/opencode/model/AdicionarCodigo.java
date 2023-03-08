package br.com.fiap.opencode.model;

public class AdicionarCodigo {
    private int idusuario;
    private String codigo;

    public AdicionarCodigo(int idusuario, String codigo) {
        this.idusuario = idusuario;
        this.codigo = codigo;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return "AdicionarCodigo [idusuario=" + idusuario + ", codigo=" + codigo + "]";
    }
}
