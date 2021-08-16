package br.com.springboot.controllers;

import java.util.Optional;

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

import br.com.springboot.model.Item;
import br.com.springboot.repository.ItemRepository;

@RestController
@RequestMapping("/itens")
public class ItemController {
    
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/{id}")
    public Item item(@PathVariable("id") Long id){
        Optional <Item> itemRetornado = this.itemRepository.findById(id);
        
        if(itemRetornado.isPresent()){
            return itemRetornado.get();

        }
        
        return null;
    }



    @PostMapping("/")
    public Item item(@RequestBody Item item){
        return this.itemRepository.save(item);
        

    }


    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable("id") Long id, @RequestBody Item item){

        Optional<Item> itemOptional = this.itemRepository.findById(id);
        if (!itemOptional.isPresent()){
            return ResponseEntity.notFound().build();

        }
        item.setId(id);
	    Item updated = itemRepository.save(item);
	    return ResponseEntity.ok().body(updated);
        
    }



    @DeleteMapping("/{id}")
    public  ResponseEntity deleteCliente(@PathVariable("id") Long id){

        Optional<Item> itemOptional = this.itemRepository.findById(id);
        if (!itemOptional.isPresent()){
            return ResponseEntity.notFound().build();

        }
	    itemRepository.deleteById(id);
	    return ResponseEntity.ok("Item deletado !");
        
    }

    @GetMapping("/list")
    public Iterable<Item> list(){
        return  this.itemRepository.findAll();
    }


}
