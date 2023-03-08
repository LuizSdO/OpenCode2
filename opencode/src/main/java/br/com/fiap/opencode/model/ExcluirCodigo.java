package br.com.fiap.opencode.model;

public class ExcluirCodigo {
    private int idusuario;
    private String senhaUsuario;
    private int idCodigo;
    public ExcluirCodigo(int idusuario, String senhaUsuario, int idCodigo) {
        this.idusuario = idusuario;
        this.senhaUsuario = senhaUsuario;
        this.idCodigo = idCodigo;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public String getSenhaUsuario() {
        return senhaUsuario;
    }
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    public int getIdCodigo() {
        return idCodigo;
    }
    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }
    @Override
    public String toString() {
        return "ExcluirCodigo [idusuario=" + idusuario + ", senhaUsuario=" + senhaUsuario + ", idCodigo=" + idCodigo
                + "]";
    }
    
}
