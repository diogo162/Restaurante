package org.example;


import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
public class Cliente extends Pessoa{
    @EmbeddedId
    @GeneratedValue

    private int id_cliente;

    @OneToOne
    @JoinColumn(name="id_pedido")
    private Pedido id_pedido;



    public Cliente() {
        super();
    }




}
