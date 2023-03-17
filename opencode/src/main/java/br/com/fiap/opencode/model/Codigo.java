package br.com.fiap.opencode.model;

public class Codigo {
    private Long id;
    private Long idUsuario;
    private String codigo;

    
    public Codigo(Long id, Long idUsuario, String codigo) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.codigo = codigo;
    }
    
    
    public Codigo() {
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Codigo [id=" + id + ", idUsuario=" + idUsuario + ", codigo=" + codigo + "]";
    }
    

    
}
