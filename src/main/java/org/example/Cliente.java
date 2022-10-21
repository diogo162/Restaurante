package org.example;


import javax.persistence.*;


@Entity
public class Cliente extends Pessoa{
//    @Id
//    @GeneratedValue
//
//    private int id_cliente;

    @OneToMany
    @JoinColumn(name="id_pedido")
    private Pedido pedido;



    public Cliente() {
        super();
    }




}
