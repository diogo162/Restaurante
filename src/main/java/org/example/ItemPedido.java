package org.example;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sun.istack.NotNull;

import java.util.List;


@Entity
public class ItemPedido {
    @Id
    @GeneratedValue
    private int id_itemPedido;
    @NotNull
    private int quantidade;
    @NotNull
    @OneToMany
    private List<ItemComer> item;
    @ManyToOne
    @JoinColumn(name="Cardapio")
    private Cardapio cardapio;

}
