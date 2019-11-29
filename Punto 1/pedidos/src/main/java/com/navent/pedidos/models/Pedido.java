package com.navent.pedidos.models;

public class Pedido {
    private Integer idPedido;
    private String nombre;
    private float monto;
    private float descuento;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, String nombre, float monto, float descuento) {
        this.idPedido = idPedido;
        this.nombre = nombre;
        this.monto = monto;
        this.descuento = descuento;
    }

    public Pedido(Integer idPedido, String nombre, float monto) {
        this.idPedido = idPedido;
        this.nombre = nombre;
        this.monto = monto;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
}
