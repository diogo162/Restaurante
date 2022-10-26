package org.servicos;

import org.example.HibernateUtil;
import org.example.Mesa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.StringReader;
import java.util.List;
import java.util.Scanner;

public class mesaImplementar implements mesaServico{

    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();



    public void abrirMesa(int id){
        List<Mesa> mesa = (List<Mesa>) session.createQuery("from Mesa").list();
        for(Mesa mes : mesa){
            if (id == mes.getId_mesa()){
                mes.setStatus("aberta");
                System.out.println(mes.getStatus());
            }
        }
    }

    @Override
    public void listarMesas(){
        System.out.println("Mesas");
        Scanner leitor = new Scanner(System.in);
        List result = session.createQuery( "from Mesa" ).list();
        for ( Mesa mesa : (List<Mesa>) result ) {
            System.out.println( mesa.getId_mesa() + " - " + mesa.getOrder() + " - " + mesa.getStatus());
        }
        System.out.println("O que deseja fazer a seguir? \n1)Selecionar mesa \n2)Sair");
        int escolha = leitor.nextInt();
        int table = leitor.nextInt();
        while(escolha != 5) {
            switch (escolha) {
                case (1):
                    System.out.println("Selecione uma mesa");
                    table = leitor.nextInt();
                    break;
                case (2):
                    System.out.println("Estoque");
                    break;
                case (3):
                    System.out.println("Delivery");
                    listarMesasDelivery();
                    break;
                case (5):
                    System.out.println("sair");
                    break;
            }
        }
    }

    @Override
    public void listarMesasDelivery() {

    }


    @Override
    public void fecharMesa(int id){
        List<Mesa> mesa = (List<Mesa>) session.createQuery("from Mesa").list();
        for(Mesa mes : mesa){
            if (id == mes.getId_mesa()){
                mes.setStatus("fechada");
                System.out.println(mes.getStatus());
            }
        }
    }
}
