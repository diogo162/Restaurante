package org.example;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ingrediente {
    @NotNull
    private String nome;
    @Id
    @GeneratedValue
    private int id_ingrediente;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "id_ingrediente", insertable = false, updatable = false)
    })
    private List<Ingrediente> itemComer;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public List<Ingrediente> getItemComer() {
        return itemComer;
    }

    public void setItemComer(List<Ingrediente> itemComer) {
        this.itemComer = itemComer;
    }
}

