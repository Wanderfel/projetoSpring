package br.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.springboot.model.Item;

/**
 * InnerItemRepository
 */
public interface ItemRepository extends CrudRepository<Item, Long> {

    
}
