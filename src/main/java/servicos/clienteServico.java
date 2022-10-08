package servicos;

import javax.persistence.Query;

import org.example.HibernateUtil;
import org.example.Pessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class clienteServico {

    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();


    public void criarCliente(String cpf, String nome, int telefone_celular){
        session.beginTransaction();
        session.save( new Pessoa(cpf, nome, telefone_celular));
        session.getTransaction().commit();
    }

    public void deletarCliente(String cpf, String nome, int telefone_celular){


    }

}
