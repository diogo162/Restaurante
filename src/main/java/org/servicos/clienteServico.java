package org.servicos;
import org.example.Cliente;
import org.example.Endereco;

public interface clienteServico {

    void criarCliente(String cpf, String nome, int telefone_celular, String endereco);

    void criarCliente(String cpf, String nome, int telefone_celular, Endereco endereco);

    void listarClientes();

    public void deletarCliente(String cpf);


}
