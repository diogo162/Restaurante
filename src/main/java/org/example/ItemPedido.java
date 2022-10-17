package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sun.istack.NotNull;

import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class ItemPedido {
    @Id
    private int id;
    @NotNull
    private int quantidade;
    @NotNull
    @OneToMany
    private List<ItemComer> item;
    @Id
    @GeneratedValue
    private int id_itemPedido;

}
