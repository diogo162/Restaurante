package servicos;

import org.example.Cliente;

public interface clienteServico {

    public void criarCliente(String cpf, String nome, int telefone_celular);

    void listarClientes();

    public void deletarCliente(String cpf, String nome, int telefone_celular);

    public Cliente criarCliente(Cliente cliente);

}
