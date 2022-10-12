package servicos;

import org.example.Cliente;
import org.hibernate.service.Service;

public interface pedidoServico{


    void criarPedido(String cpf, String nome, int telefone_celular);

    void listarPedidos();

    void deletarPedido(Cliente cliente, String cpf, String nome, int telefone_celular);
}
