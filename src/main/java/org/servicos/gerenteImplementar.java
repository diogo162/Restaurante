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


    @Override
    public void criarGerente(String cpf, String nome, int telefone_celular, String senha){
        session.beginTransaction();
        session.save( new Gerente());
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
    }


    @Override
    public void deletarGerente(String cpf, String nome, int telefone_celular){
        System.out.println("------- DELETE");
        session.beginTransaction();
        Query query = session.createQuery("DELETE from Gerente p where p.cpf = :cpf");
        query.setParameter("cpf", cpf);
        query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("cliente deletado com sucesso");

    }

    @Override
    public void logar() {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Escolha a função:\n1)Mesas\n2)Estoque\n3)Delivery\n4)Funcionários");
        int escolha = leitor.nextInt();
        switch(escolha){
            case(1):
                System.out.println("Mesas");
                List result = session.createQuery( "from Mesa" ).list();
                for ( Mesa mesa : (List<Mesa>) result ) {
                    System.out.println( mesa.getId_mesa() + " - " + mesa.getOrder() + " - " + mesa.getStatus());
                }
                break;
            case(2):
                System.out.println("Estoque");
                break;
            case(3):
                System.out.println("Delivery");
                break;
            case(4):
                System.out.println("Funcionários");
                break;
        }

    }

}
