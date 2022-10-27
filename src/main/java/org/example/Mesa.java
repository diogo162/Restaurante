package org.example;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Mesa {
    public Mesa(int id_mesa, String status) {
        this.id_mesa = id_mesa;
        this.status = status;
    }

    @Id
    private int id_mesa;
    @ManyToOne
    @JoinColumn(name = "order_id_pedido")
    private Pedido order;



    private String status;

    public Mesa() {
    }


    public Pedido getOrder() {
        return order;
    }

    public void setOrder(Pedido order) {
        this.order = order;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
