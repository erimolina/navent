package com.navent.pedidos.repositories;

import com.navent.pedidos.models.Pedido;

public class PedidoRepo implements Repository {

    private PedidosDAO pedidosDao;
    private BumexMemcached bumexMemcached;

    public PedidoRepo(PedidosDAO pedidosDao, BumexMemcached bumexMemcached) {
        this.pedidosDao = pedidosDao;
        this.bumexMemcached = bumexMemcached;
    }

    @Override
    public Pedido get(Integer id) {
        Object pedidoCache = bumexMemcached.get(id.toString());
        if(pedidoCache != null) {
            return (Pedido) pedidoCache;
        }
        Pedido pedido = pedidosDao.select(id);
        if(pedido != null){
            bumexMemcached.set(id.toString(), pedido);
            return pedido;
        }
        return null;
    }

    @Override
    public Pedido create(Pedido pedido) {
        pedidosDao.insertOrUpdate(pedido);
        return pedido;
    }

    @Override
    /**
     * El update está separado del create, ya que tengo que fijarme si existe en cache
     * para ver si una vez que lo actualizo, lo actualizo también en cache, tengo dos opciones
     * actualizarlo y escribirlo en cache independiemente que esté o o no, o bien fijarme si está
     * antes de actualizarlo, es una escritura en cache, contra una lectura y escritura. Suponiendo
     * que no hay problemas de optimización con cache, primero me fijo si está y si está, lo actualizo
     */
    public Pedido update(Pedido pedido) {
        pedidosDao.insertOrUpdate(pedido);
        Object pedidosCache = bumexMemcached.get(pedido.getIdPedido().toString());
        if(pedidosCache != null){
            bumexMemcached.set(pedido.getIdPedido().toString(), pedido);
        }
        return pedido;
    }

    @Override
    /**
     * Si el pedido existe en el cache, lo elimino
     *
     */
    public void delete(int id) {
        Pedido pedido = new Pedido(id);
        pedidosDao.delete(pedido);
        Object pedidosCache = bumexMemcached.get(pedido.getIdPedido().toString());
        if(pedidosCache != null){
            bumexMemcached.delete(pedido.getIdPedido().toString());
        }

    }
}

