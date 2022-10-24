package org.example;


import javax.persistence.*;


@Entity
public class Cliente extends Pessoa{
    //@Id
    //@GeneratedValue

    //private int id_cliente;

    @ManyToOne
    @JoinColumn(name="id_pedido")
    private Pedido pedido;



    public Cliente() {
        super();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
