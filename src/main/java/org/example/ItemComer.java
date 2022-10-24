package org.example;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name="id_ingrediente")
    private List<Ingrediente> ingrediente;
    @NotNull
    private String tipo;

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<Ingrediente> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(List<Ingrediente> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
