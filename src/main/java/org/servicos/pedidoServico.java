package org.servicos;

import org.example.Cliente;
import org.example.Mesa;
import org.example.Pedido;
import org.hibernate.service.Service;

public interface pedidoServico{
    void criarPedido(Pedido pedido);


    void associarMesa(int table, Pedido pedido);

    void listarPedidos();

    void listarPedidosDelivery();

    void deletarPedido(int id);

}
