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

    private List<ItemComer> itemCardapio;

    public void adicionarCardapio(Cardapio cardapio, ItemComer itemCardapio) {
        cardapio.add(itemCardapio);
    }

    private void add(ItemComer itemCardapio) {
    }

    public Cardapio() {

    }
}
