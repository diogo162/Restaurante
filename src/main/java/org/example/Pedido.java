package org.example;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Pedido {
    @Id
    @NotNull
    private int id_pedido;

    @OneToMany(mappedBy = "ItemPedido")
    private List<ItemPedido> itens;
    @NotNull
    private float valor;


    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @NotNull
    private LocalDate dataPedido;
    @NotNull
    private String tipo;
    @OneToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }


    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
