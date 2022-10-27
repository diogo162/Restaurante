package org.servicos;

import org.example.Gerente;
import org.example.HibernateUtil;
import org.example.Mesa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class mesaImplementar implements mesaServico{

    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();

    Scanner leitor = new Scanner(System.in);

    public void abrirMesa(int table){
        Transaction tx = session.beginTransaction();
        Mesa mesa = session.load(Mesa.class, table);
        mesa.setStatus("aberta");
        session.update(mesa);
        tx.commit();
        System.out.println("Mesa aberta");
    }

    @Override
    public void fecharMesa(int table) {
        Transaction tx;
        Mesa mesa;
        tx = session.beginTransaction();
        mesa = session.load(Mesa.class, table);
        mesa.setStatus("fechada");
        session.update(mesa);
        tx.commit();
        System.out.println("Mesa fechada");

    }

    @Override
    public void listarMesas(){
        System.out.println("Mesas");
        List result = session.createQuery( "from Mesa" ).list();
        for ( Mesa mesa : (List<Mesa>) result ) {
            System.out.println( mesa.getId_mesa() + " - " + mesa.getOrder() + " - " + mesa.getStatus());
        }
        System.out.println("O que deseja fazer a seguir? \n1)Criar mesa\n2)Selecionar mesa \n3)Sair");
        int escolha = leitor.nextInt();
        int table;
        while(escolha != 3) {
            switch (escolha) {
                case(1):
                    System.out.println("Quantas mesas existem?");
                    int quantidade = leitor.nextInt();
                    for (int i = 1; i < quantidade + 1; i++) {
                        System.out.println("criando mesas");
                        session.beginTransaction();
                        session.save(new Mesa(i, "aberta"));
                        session.getTransaction().commit();
                    }
                    escolha = leitor.nextInt();
                    System.out.println("O que deseja fazer a seguir? \n1)Criar mesa\n2)Selecionar mesa \n3)Sair");
                    break;
                case (2):
                    System.out.println("Selecione uma mesa");
                    table = leitor.nextInt();
                    gerenciarMesa(table, escolha);
                    escolha = leitor.nextInt();
                    System.out.println("O que deseja fazer a seguir? \n1)Criar mesa\n2)Selecionar mesa \n3)Sair");
                    break;
            }
        }
    }



    private void gerenciarMesa(int table, int escolha) {
        escolha = 4;
        while(escolha != 3) {
            System.out.println("O que deseja fazer com a mesa " + escolha + "?");
            System.out.println("1)Abrir mesa\n2)fechar mesa\n3)voltar");
            escolha = leitor.nextInt();
            switch (escolha) {
                case (1):
                    //atualizar mesa
                    abrirMesa(table);
                    System.out.println("1)Abrir mesa\n2)fechar mesa\n3)voltar");
                    escolha = leitor.nextInt();
                    break;
                case (2):
                    //atualizar mesa
                    fecharMesa(table);
                    System.out.println("1)Abrir mesa\n2)fechar mesa\n3)voltar");
                    escolha = leitor.nextInt();
                    break;
            }
        }




    }
}
