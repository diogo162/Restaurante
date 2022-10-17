package org.servicos;

import org.example.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class itemPedidoImplementar implements itemPedidoServico{

    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public void adicionarItem(int id, int quantidade, ItemPedido item) {
        session.beginTransaction();
        session.save( new ItemPedido());
        session.getTransaction().commit();

    }


    @Override
    public void removerItem(int id) {
        session.beginTransaction();
        Query query = session.createQuery("DELETE from ItemPedido i WHERE i.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void atualizarItem(int id) {

        List<Mesa> mesa = (List<Mesa>) session.createQuery("from Mesa").list();
        for(Mesa mes : mesa){
            if (id == mes.getId_mesa()){
                mes.setStatus("fechada");
                System.out.println(mes.getStatus());
            }
        }
    }
}
