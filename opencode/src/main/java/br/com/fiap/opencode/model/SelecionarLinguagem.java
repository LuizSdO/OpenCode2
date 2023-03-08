package br.com.fiap.opencode.model;

public class SelecionarLinguagem {
    private String nomeLinguagem;

    public SelecionarLinguagem(String nomeLinguagem) {
        this.nomeLinguagem = nomeLinguagem;
    }

    public String getNomeLinguagem() {
        return nomeLinguagem;
    }

    public void setNomeLinguagem(String nomeLinguagem) {
        this.nomeLinguagem = nomeLinguagem;
    }

    @Override
    public String toString() {
        return "SelecionarLinguagem [nomeLinguagem=" + nomeLinguagem + "]";
    }


}