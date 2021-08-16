package br.com.springboot.model;

import java.util.List;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "item")
    List<Pedido> pedidos;

    
    
}
