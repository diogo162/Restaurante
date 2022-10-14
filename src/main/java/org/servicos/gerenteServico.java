package org.servicos;

public interface gerenteServico {

    void criarGerente(String cpf, String nome, int telefone_celular, String senha);

    void trocarSenha(String cpf, String senha);

    void deletarGerente(String cpf, String nome, int telefone_celular);

    void listarFuncionarios();

    void logar();
}
