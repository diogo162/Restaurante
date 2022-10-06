package org.example;

import com.sun.istack.NotNull;

import javax.persistence.OneToMany;
import java.util.List;

public class ItemPedido {
    @NotNull
    private int quantidade;
    @NotNull
    @OneToMany
    private List<ItemComer> item;
}
