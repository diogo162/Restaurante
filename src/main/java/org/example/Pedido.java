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

    @OneToMany
    @JoinColumn(name = "id_pedido")
    private List<ItemPedido> itens;
    @NotNull
    private float valor;

    //@ManyToOne
    //@JoinColumn(name = "cpf")
    //private Cliente cliente;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "tipo", insertable = false, updatable = false),
            @JoinColumn(name = "id_pedido", insertable = false, updatable = false),
            @JoinColumn(name = "valor", insertable = false, updatable = false),
            @JoinColumn(name = "dataPedido", insertable = false, updatable = false)
    })
    private Cliente cliente;
    @NotNull
    private LocalDate dataPedido;
    @NotNull
    private String tipo;
    @ManyToOne
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

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }
}
