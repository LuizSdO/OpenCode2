package br.com.fiap.opencode.model;

public class PaginaInicial {
    private Long id;
    private int idUsuario;
    private int idCodigo;
    private String senhaUsuario;
    
    public PaginaInicial(Long id, int idUsuario, int idCodigo, String senhaUsuario) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idCodigo = idCodigo;
        this.senhaUsuario = senhaUsuario;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

  
    
    @Override
    public String toString() {
        return "PaginaInicial [id=" + id + "idUsuario=" + idUsuario + ", idCodigo=" + idCodigo + ", senhaUsuario=" + senhaUsuario + "]";
    }
    

    
    
}
