package org.example;

import com.sun.istack.NotNull;

import javax.persistence.OneToMany;

public class ItemPedido {
    @NotNull
    private int quantidade;
    @NotNull
    @OneToMany
    private ItemComer item;
}
