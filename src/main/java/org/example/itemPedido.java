package org.example;

import javax.persistence.*;

import com.sun.istack.NotNull;

import java.util.List;


@Entity
public class itemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_itemPedido;
    @NotNull
    private int quantidade;
    @NotNull
    @OneToMany
    @JoinColumn(name="id_pedido")
    private List<itemComer> item;

    public itemPedido(int id_itemPedido, int quantidade, List<itemComer> item) {
        this.id_itemPedido = id_itemPedido;
        this.quantidade = quantidade;
        this.item = item;
    }

    public itemPedido() {
    }

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

    public List<itemComer> getItem() {
        return item;
    }

    public void setItem(List<itemComer> item) {
        this.item = item;
    }
}
