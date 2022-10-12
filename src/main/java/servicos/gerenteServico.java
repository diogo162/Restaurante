package servicos;

public interface gerenteServico {
    void criarGerente(String cpf, String nome, int telefone_celular, String senha);
    void trocarSenha();
    void deletarGerente();
}
