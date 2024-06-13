package com.politecnicomalaga.entidadbancaria;

public class Operacion {
    private long codigo;
    private float cantidad;
    private String fecha;

    public Operacion(long codigo, float cantidad, String fecha) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String verDatos() {
        return  "\n---------------------------" +
                "\ncodigo: " + codigo +
                "\ncantidad:" + cantidad +
                "\nfecha:" + fecha ;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "codigo=" + codigo +
                ", cantidad=" + cantidad +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
