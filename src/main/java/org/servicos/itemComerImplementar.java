package org.servicos;

import org.example.HibernateUtil;
import org.example.itemComer;
import org.example.itemPedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class itemComerImplementar implements itemComerServico{

    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();


    public void adicionarItem() {
        session.beginTransaction();
        session.save( new itemPedido());
        session.getTransaction().commit();
    }

    @Override
    public void listarCardapio() {
        List result = session.createQuery( "from itemComer" ).list();
        for ( itemComer item : (List<itemComer>) result ) {
            System.out.println( item.getId_item() + " - " + item.getValor() +" - " + item.getValor() + " - " + item.getIngrediente());
        }
    }
    }

