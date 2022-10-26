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
        System.out.println("O que deseja fazer?\n1)mudar salário\n2)demitir funcionário\n3)voltar");
        Scanner resposta = new Scanner(System.in);
//        switch(resposta){
//            case(1):
//                break;
//            case(2):
//                break;
//            case(3):
//                break;
//        }
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
    public void verificarSenha(String senha){
        System.out.println("------- DELETE");
        session.beginTransaction();
        Query query = session.createQuery("SELECT senha from Gerente p where p.senha = :senha");
        session.getTransaction().commit();
        System.out.println("login realizado com sucesso");
    }

    @Override
    public void logar() {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Escolha a função:\n1)Mesas\n2)Estoque\n3)Delivery\n4)Funcionários\n5)Sair");
        int escolha = leitor.nextInt();
        while(escolha != 5) {
            switch (escolha) {
                case (1):
                    System.out.println("Mesas");
                    mesa.listarMesas();
                    break;
                case (2):
                    System.out.println("Estoque");
                    break;
                case (3):
                    System.out.println("Delivery");
                    mesa.listarMesasDelivery();
                    break;
                case (4):
                    System.out.println("Funcionários");
                    listarFuncionarios();
                    break;
                case (5):
                    System.out.println("sair");
                    break;
            }
        }

    }

}
