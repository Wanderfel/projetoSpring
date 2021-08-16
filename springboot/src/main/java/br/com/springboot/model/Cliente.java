package br.com.springboot.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    //@Column("nomeCliente") -> caso eu quisesse trocar o nome da coluna do banco
    @NotNull
    private String nome;
    
    @NotNull
    private String cpf;
    
    private String cep;

    
}
