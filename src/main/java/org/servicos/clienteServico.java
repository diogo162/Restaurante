package org.servicos;

public interface clienteServico {

    void criarCliente(String cpf, String nome, int telefone_celular, String endereco);


    void listarClientes();

    public void deletarCliente(String cpf);


}
