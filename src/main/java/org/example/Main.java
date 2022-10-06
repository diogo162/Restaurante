package org.example;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String args[]) {
        HibernateUtil hu = new HibernateUtil();
        SessionFactory sessionFactory = hu.getSessionFactory();
        Session session = sessionFactory.openSession();


        session.beginTransaction();
//        session.save( new Pessoa("64783763565", "Alana"));

        session.getTransaction().commit();

        //busca todos os dados na base
        List result = session.createQuery( "from Pessoa" ).list();
        for ( Pessoa pessoa : (List<Pessoa>) result ) {
            System.out.println( pessoa.getCpf() + " - " + pessoa.getCpf() + " - " + pessoa.getNome());
        }

        System.out.println("------- com WHERE");
        Query query = session.createQuery( "from Pessoa p where p.cpf = :cpf" );
        query.setParameter("cpf","09829992809");
        result = query.getResultList();
        for ( Pessoa pessoa : (List<Pessoa>) result ) {
            System.out.println( pessoa.getCpf() + " - " + pessoa.getCpf() + " - " + pessoa.getNome());
        }

//        System.out.println("------- DELETE");
//        session.beginTransaction();
//        query = session.createQuery( "DELETE from Pessoa p where p.cpf = :cpf" );
//        query.setParameter("cpf","09829992809");
//        query.executeUpdate();
//        session.getTransaction().commit();


        session.close();
        sessionFactory.close();
    }
}
