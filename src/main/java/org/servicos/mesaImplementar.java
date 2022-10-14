package org.servicos;

import org.example.HibernateUtil;
import org.example.Mesa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class mesaImplementar {

    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();



    public void abrirMesa(){

    }

    public void listarMesas(){
        System.out.println("Mesas");
        List result = session.createQuery( "from Mesa" ).list();
        for ( Mesa mesa : (List<Mesa>) result ) {
            System.out.println( mesa.getId_mesa() + " - " + mesa.getOrder() + " - " + mesa.getStatus());
        }

    }
    public void fecharMesa(){

    }
}
