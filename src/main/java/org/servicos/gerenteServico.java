package org.servicos;

public interface gerenteServico {

    void criarGerente(String cpf, String nome, int telefone_celular, String senha);

    void removerFuncionario(String cpf);


    void criarEntregador(String cpf, String nome, int CNH, String veiculo, float horas, float salario_hora);

    void trocarSenha(String cpf, String senha);

    void deletarGerente(String cpf, String nome, int telefone_celular);

    void listarFuncionarios();

    void criarFuncionario(String cpf, String nome, int telefone_celular, float senha);


    Boolean verificarSenha(String senha);
}
