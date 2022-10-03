package org.example;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente extends Pessoa{
    @Id
    @GeneratedValue
    private int id_cliente;
}
