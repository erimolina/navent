package com.navent.pedidos.services;

import com.navent.pedidos.models.Pedido;

public interface Service {
     Pedido get(int id) throws Exception;
     Pedido create(Pedido pedido) throws Exception;
     Pedido update(Pedido pedido) throws Exception;
     void delete(int id);
}
