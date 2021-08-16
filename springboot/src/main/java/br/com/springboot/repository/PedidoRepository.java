package br.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.springboot.model.Pedido;

/**
 * InnerPedidoRepository
 */
public interface PedidoRepository extends CrudRepository <Pedido, Long>{

    
}
