package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Id;
import java.time.LocalDate;

public class Pedido {
    @Id
    @NotNull
    private int id_pedido;
    @NotNull
    private ItemPedido[] itens;
    @NotNull
    private float valor;
    private Cliente cliente;
    @NotNull
    private LocalDate dataPedido;
    @NotNull
    private String tipo;
    private Mesa mesa;
}
