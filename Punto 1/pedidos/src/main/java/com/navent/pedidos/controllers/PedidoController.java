package com.navent.pedidos.controllers;

import com.navent.pedidos.models.Pedido;
import com.navent.pedidos.services.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private Service pedidoService;

    public PedidoController() {
    }

    public PedidoController(Service pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * Descripción: Servicio para buscar pedidos por ID
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable(value = "id") int id){
        Pedido pedido;
        try {
            pedido = pedidoService.get(id);
        } catch (Exception e) {
           return new ResponseEntity<Pedido>(HttpStatus.BAD_REQUEST);
        }
        if(pedido == null){
            return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
    }

    /**
     * Descripción: Servicio para borrar un pedido
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletePedido(@PathVariable(value = "id") int id){
        pedidoService.delete(id);
        return new ResponseEntity<Pedido>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido){
        try {
           pedidoService.create(pedido);
        } catch (Exception e) {
            return new ResponseEntity<Pedido>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Pedido>(pedido,HttpStatus.CREATED);
    }

    /**
     *
     * Descripción: Servicio para modificar un pedido
     * @param id
     * @param pedido
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable(value = "id") int id, @RequestBody Pedido pedido){
        pedido.setIdPedido(id);
        try {
            pedidoService.update(pedido);
        } catch (Exception e) {
            return new ResponseEntity<Pedido>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
    }
}
