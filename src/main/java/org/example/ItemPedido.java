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
    @JoinColumn(name="id_pedido")
    private List<ItemComer> item;

    public int getId_itemPedido() {
        return id_itemPedido;
    }

    public void setId_itemPedido(int id_itemPedido) {
        this.id_itemPedido = id_itemPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<ItemComer> getItem() {
        return item;
    }

    public void setItem(List<ItemComer> item) {
        this.item = item;
    }
}
