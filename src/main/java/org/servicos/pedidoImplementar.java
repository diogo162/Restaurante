package org.servicos;


import org.example.HibernateUtil;
import org.example.Mesa;
import org.example.Pedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class pedidoImplementar implements pedidoServico {


    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public void criarPedido(Pedido pedido){
        session.beginTransaction();
        session.save( new Pedido());
        session.getTransaction().commit();
    }




    @Override
    public void associarMesa(int table, Pedido pedido){
        Mesa mesa = new Mesa();
        mesa.setId_mesa(table);
        mesa.setStatus("fechada");
        mesa.setOrder(pedido);
    }

    @Override
    public void listarPedidos() {
        //busca todos os dados na base
        List result = session.createQuery( "from Pedido" ).list();
        for ( Pedido pedido : (List<Pedido>) result ) {
            System.out.println( pedido.getItens() + " - " + pedido.getValor() + " - " + pedido.getCliente() + pedido.getDataPedido()+ pedido.getTipo() + pedido.getTipo());
        }
    }

    @Override
    public void listarPedidosDelivery() {
        //busca todos os dados na base
        List result = session.createQuery( "from Pedido where tipo = pedido" ).list();
        for ( Pedido pedido : (List<Pedido>) result ) {
            System.out.println( pedido.getItens() + " - " + pedido.getValor() + " - " + pedido.getCliente() + pedido.getDataPedido()+ pedido.getTipo() + pedido.getTipo());
        }
    }


    @Override
    public void deletarPedido(int id_pedido) {
        System.out.println("------- DELETE");
        session.beginTransaction();
        Query query = session.createQuery("DELETE from Pedido p where p.id_pedido = :id_pedido");
        query.setParameter("id_pedido", id_pedido);
        query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("cliente deletado com sucesso");

    }
}
