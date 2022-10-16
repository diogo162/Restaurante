package org.servicos;

import org.example.HibernateUtil;
import org.example.Mesa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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
        List result = session.createQuery( "from Mesa" ).list();
        for ( Mesa mesa : (List<Mesa>) result ) {
            System.out.println( mesa.getId_mesa() + " - " + mesa.getOrder() + " - " + mesa.getStatus());
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
