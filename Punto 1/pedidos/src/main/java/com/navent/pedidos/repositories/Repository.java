package com.navent.pedidos.repositories;

import com.navent.pedidos.models.Pedido;

public interface Repository {
    Pedido get(Integer id);
    Pedido create(Pedido pedido);
    Pedido update(Pedido pedido);
    void delete(int id);
}




