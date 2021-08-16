package br.com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.springboot.model.Cliente;

/**
 * ClienteRepository
 */
public interface ClienteRepository extends CrudRepository<Cliente,Long> {

    @Query("SELECT c FROM Cliente c WHERE c.id > :id")
    public List<Cliente> findMoreThan(@Param("id") Long id);

    public List<Cliente> findByIdGreaterThan(Long id);

    public List<Cliente> findByNome(String nome);

   

    
}