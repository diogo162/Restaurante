package org.servicos;

import org.example.Cliente;
import org.example.Pedido;
import org.hibernate.service.Service;

public interface pedidoServico{


    void criarPedido(String cpf, String nome, int telefone_celular);

    void listarPedidos();

    void deletarPedido(Pedido pedido, String cpf, String nome, int telefone_celular);
}
