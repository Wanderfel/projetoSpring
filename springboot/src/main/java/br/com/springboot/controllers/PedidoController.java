package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.model.Item;
import br.com.springboot.model.Pedido;
import br.com.springboot.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/{id}")
    public Pedido pedido(@PathVariable("id") Long id){
        Optional <Pedido> pedidoRetornado = this.pedidoRepository.findById(id);
        
        if(pedidoRetornado.isPresent()){
            return pedidoRetornado.get();

        }
        
        return null;
    }

    @PostMapping("/")
    public ResponseEntity pedido(@Valid @RequestBody Pedido pedido){
        List<Item> itens = pedido.getItens();
        if(itens.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lista Vazia !");
        }
        Pedido saved = this.pedidoRepository.save(pedido);
        return ResponseEntity.ok().body(saved); 
        

    }

    @PutMapping("/{id}")
    public ResponseEntity updatePedido(@PathVariable("id") Long id, @RequestBody Pedido pedido){

        Optional<Pedido> pedidoOptional = this.pedidoRepository.findById(id);
        if (!pedidoOptional.isPresent()){
            return ResponseEntity.notFound().build();

        }
        pedido.setId(id);
	    Pedido updated = pedidoRepository.save(pedido);
	    return ResponseEntity.ok().body(updated);
        
    }


    @DeleteMapping("/{id}")
    public  ResponseEntity deletePedido(@PathVariable("id") Long id){

        Optional<Pedido> pedidoOptional = this.pedidoRepository.findById(id);
        if (!pedidoOptional.isPresent()){
            return ResponseEntity.notFound().build();

        }
	    pedidoRepository.deleteById(id);
	    return ResponseEntity.ok("Pedido deletado !");
        
    }


    @GetMapping("/list")
    public Iterable<Pedido> list(){
        return  this.pedidoRepository.findAll();
    }

}
