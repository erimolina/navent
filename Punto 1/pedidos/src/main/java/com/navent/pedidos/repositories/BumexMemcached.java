package com.navent.pedidos.repositories;

public interface BumexMemcached {

    void set(String key, Object value);
    Object get(String key);
    void delete(String key);

}
