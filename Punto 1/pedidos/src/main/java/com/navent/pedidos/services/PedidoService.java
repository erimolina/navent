package com.navent.pedidos.services;

import com.navent.pedidos.models.Pedido;
import com.navent.pedidos.repositories.Repository;
import org.springframework.web.bind.annotation.RestController;


public class PedidoService implements Service {

    private Repository pedidoRepo;

    public PedidoService() {
    }

    public PedidoService(Repository pedidoRepo) {
        this.pedidoRepo = pedidoRepo;
    }

    @Override
    public Pedido get(int id) throws Exception {
        if(id > 0){
            return pedidoRepo.get(id);
        }
        throw new Exception("ID inválido");
    }

    @Override
    public Pedido create(Pedido pedido) throws Exception {
        validate(pedido);
        return pedidoRepo.create(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) throws Exception {
        validate(pedido);
        return pedidoRepo.update(pedido);
    }

    private void validate(Pedido pedido) throws Exception {
        if (pedido.getMonto() < 0 || pedido.getNombre() == "" || pedido.getDescuento() < 0) {
            throw new Exception("Datos Erroneos");
        }
    }

    @Override
    public void delete(int id) {
        pedidoRepo.delete(id);
    }
}
