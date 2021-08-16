package br.com.springboot.controllers;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.springboot.model.Cliente;
import br.com.springboot.repository.ClienteRepository;



/**
 * UserController
 */
@RestController

// mapear nossa classe para que seja acessível via requisição http/https por este link: http://localhost:8080/users
@RequestMapping("/clientes")
public class ClienteController {

    

    @Autowired
    private ClienteRepository clienteRepository;


    
    @GetMapping("/{id}")
    public Cliente cliente(@PathVariable("id") Long id){
        Optional <Cliente> clienteRetornado = this.clienteRepository.findById(id);
        
        if(clienteRetornado.isPresent()){
            return clienteRetornado.get();

        }
        
        return null;
    }

    @PostMapping("/")
    public Cliente cliente(@Valid @RequestBody Cliente cliente){
        return this.clienteRepository.save(cliente);
        

    }

    @PutMapping("/{id}")
    public ResponseEntity updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){

        Optional<Cliente> clienteOptional = this.clienteRepository.findById(id);
        if (!clienteOptional.isPresent()){
            return ResponseEntity.notFound().build();

        }
        cliente.setId(id);
	    Cliente updated = clienteRepository.save(cliente);
	    return ResponseEntity.ok().body(updated);
        
    }


    @DeleteMapping("/{id}")
    public  ResponseEntity deleteCliente(@PathVariable("id") Long id){

        Optional<Cliente> clienteOptional = this.clienteRepository.findById(id);
        if (!clienteOptional.isPresent()){
            return ResponseEntity.notFound().build();

        }
	    clienteRepository.deleteById(id);
	    return ResponseEntity.ok("Cliente deletado !");
        
    }



    @GetMapping("/list")
    public Iterable<Cliente> list(){
        return  this.clienteRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public Iterable<Cliente> list(@PathVariable("id") Long id){
        return  this.clienteRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/list/findByNome/{nome}")
    public Iterable<Cliente> list(@PathVariable("nome") String nome){
        return  this.clienteRepository.findByNome(nome);
    }
}