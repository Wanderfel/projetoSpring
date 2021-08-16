package br.com.springboot.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    
    // Um Pedido ( classe corrente) para vários itens ( classe referenciada)
    @NotNull
    @ManyToMany
    @JoinTable(name = "pedido_itens")
    private List<Item> itens;

    // Vários Pedidos ( classe corrente) para um Cliente (classe referenciada)
    @NotNull
    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    
    private Cliente cliente;
    
    
}



  
