package servicos;


import org.example.Cliente;
import org.example.HibernateUtil;
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
    public void criarPedido(String cpf, String nome, int telefone_celular){
        session.beginTransaction();
        session.save( new Pedido());
        session.getTransaction().commit();
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
    public void deletarPedido(Cliente cliente, String cpf, String nome, int telefone_celular) {
        System.out.println("------- DELETE");
        session.beginTransaction();
        Query query = session.createQuery("DELETE from Pedido p where p.Cliente = :Cliente");
        query.setParameter("Cliente", cliente);
        query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("cliente deletado com sucesso");

    }
}
