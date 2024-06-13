package com.politecnicomalaga.entidadbancaria;

public class Documento {
    private String tipo;
    private String numero;

    public Documento(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String verDatos() {
        return  getTipo() + ": " + getNumero();
    }

    @Override
    public String toString() {
        return "Documento{" +
                "tipo='" + tipo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
