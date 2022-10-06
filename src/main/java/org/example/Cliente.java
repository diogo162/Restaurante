package org.example;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
public class Cliente extends Pessoa{
    @Id
    @GeneratedValue
    private int id_cliente;

    public Cliente() {
        super();
    }




}
