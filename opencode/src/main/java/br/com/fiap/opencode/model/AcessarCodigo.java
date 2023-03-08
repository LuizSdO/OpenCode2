package br.com.fiap.opencode.model;

public class AcessarCodigo {
    
    private int idUsuario;
    private int idCodigo;


    public AcessarCodigo(int idUsuario, int idCodigo) {
        this.idUsuario = idUsuario;
        this.idCodigo = idCodigo;
    }


    public int getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public int getIdCodigo() {
        return idCodigo;
    }


    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }


    @Override
    public String toString() {
        return "AcessarCodigo [idUsuario=" + idUsuario + ", idCodigo=" + idCodigo + "]";
    }


}
