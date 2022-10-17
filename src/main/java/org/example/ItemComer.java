package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ItemComer {
    @Id
    @NotNull
    private int id_item;
    @NotNull
    private String nome;
    @NotNull
    private float valor;
    @NotNull
    @OneToMany
    private Ingrediente[] ingrediente;
    @NotNull
    private String tipo;
}
