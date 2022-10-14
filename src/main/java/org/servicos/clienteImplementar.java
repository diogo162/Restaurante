package org.servicos;

import org.example.Cliente;
import org.example.HibernateUtil;
import org.example.Pessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class clienteImplementar implements clienteServico {


    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();


    @Override
    public void criarCliente(String cpf, String nome, int telefone_celular){
        session.beginTransaction();
        session.save( new Pessoa(cpf, nome, telefone_celular));
        session.getTransaction().commit();
    }

    @Override
    public void listarClientes()
    {
        //busca todos os dados na base
        List result = session.createQuery( "from Pessoa" ).list();
        for ( Pessoa pessoa : (List<Pessoa>) result ) {
            System.out.println( pessoa.getCpf() + " - " + pessoa.getCpf() + " - " + pessoa.getNome());
        }
    }

    @Override
    public void deletarCliente(String cpf, String nome, int telefone_celular) {
        System.out.println("------- DELETE");
        session.beginTransaction();
        Query query = session.createQuery("DELETE from Pessoa p where p.cpf = :cpf");
        query.setParameter("cpf", cpf);
        query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("cliente deletado com sucesso");

    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return null;
    }
}
