package org.servicos;

import org.example.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class gerenteImplementar implements gerenteServico{

    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();
    mesaServico mesa = new mesaImplementar();

    itemComerServico item = new itemComerImplementar();

    Scanner leitor = new Scanner(System.in);

    @Override
    public void criarGerente(String cpf, String nome, int telefone_celular, String senha){
        session.beginTransaction();
        session.save( new Gerente());
        session.getTransaction().commit();
    }

    @Override
    public void criarFuncionario(String cpf, String nome, int telefone_celular, float senha){
        session.beginTransaction();
        session.save( new Funcionario(cpf, nome, telefone_celular, senha));
        session.getTransaction().commit();
    }

    @Override
    public void removerFuncionario(String cpf){
        session.beginTransaction();
        Query query = session.createQuery("DELETE from Funcionario p where p.cpf = :cpf");
        query.setParameter("cpf", cpf);
        query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("Funcionario deletado com sucesso");

    }


    @Override
    public void criarEntregador(String cpf, String nome, int CNH, String veiculo, float horas, float salario_hora){
        session.beginTransaction();
        session.save( new Entregador(cpf, nome,  CNH, veiculo, horas, salario_hora));
        session.getTransaction().commit();
    }

    @Override
    public void trocarSenha(String cpf, String senha) {
        session.beginTransaction();
        System.out.println("digite seu CPF");
        Scanner scanner = new Scanner(System.in);
        cpf = scanner.nextLine();
        Gerente gerente = (Gerente) session.get( Gerente.class, (Serializable) new Gerente());
        gerente.setSenha(senha);
        session.save(gerente);
    }

    @Override
    public void listarFuncionarios()
    {
        //busca todos os funcionários registrados na base
        List result = session.createQuery( "from Funcionario" ).list();
        for ( Funcionario funcionario : (List<Funcionario>) result ) {
            System.out.println( funcionario.getCpf() + " - " + funcionario.getNome() + " - " + funcionario.getTelefone_celular());
        }
        System.out.println("O que deseja fazer?\n1)Adicionar um funcionário\n2)demitir funcionário\n3)voltar");
        int resposta = leitor.nextInt();
        switch(resposta){
            case(1):
                System.out.println("Insira o cpf:\n");
                String cpf = leitor.nextLine();
                System.out.println("Insira o nome:\n");
                String nome = leitor.nextLine();
                System.out.println("Insira o numero de contato:\n");
                int contato = leitor.nextInt();
                System.out.println("Insira o salário:\n");
                float salario = leitor.nextFloat();
                criarFuncionario(cpf, nome, contato, salario);
                break;
            case(2):
                System.out.println("Insira o cpf do funcionário a ser demitido:\n");
                cpf = leitor.nextLine();
                removerFuncionario(cpf);
                break;
        }
    }


    @Override
    public void deletarGerente(String cpf, String nome, int telefone_celular){
        System.out.println("------- DELETE");
        session.beginTransaction();
        Query query = session.createQuery("DELETE from Gerente p where p.cpf = :cpf");
        query.setParameter("cpf", cpf);
        query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("Gerente deletado com sucesso");
    }

    @Override
    public Boolean verificarSenha(String senha) {
        List result = session.createQuery("from Gerente").list();
        for (Gerente gerente : (List<Gerente>) result) {
            if (senha == gerente.getSenha()) {
                return true;
            }
        }
        return false;
    }
}
