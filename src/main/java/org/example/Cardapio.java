package org.example;

import org.hibernate.mapping.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cardapio {
    @Id
    private int id;
    @OneToMany
    private Set<ItemComer> itemCardapio;

    public Cardapio(ItemComer itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    public Cardapio() {

    }
}
