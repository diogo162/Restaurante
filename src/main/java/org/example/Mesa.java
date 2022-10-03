package org.example;

import com.sun.istack.NotNull;

import javax.persistence.Id;

public class Mesa {
    @Id
    @NotNull
    private int id_mesa;
    private Pedido order;
    @NotNull
    private boolean status;
}
