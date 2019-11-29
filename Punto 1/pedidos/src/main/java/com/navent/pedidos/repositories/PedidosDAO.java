package com.navent.pedidos.repositories;

import com.navent.pedidos.models.Pedido;

public interface PedidosDAO{
    void insertOrUpdate(Pedido pedido);
    void delete(Pedido pedido);
    Pedido select(Integer idPedido);
}