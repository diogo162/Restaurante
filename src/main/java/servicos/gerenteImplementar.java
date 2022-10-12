package servicos;

import org.example.Gerente;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class gerenteImplementar implements gerenteServico{

    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();


    @Override
    public void criarGerente(String cpf, String nome, int telefone_celular, String senha){
        session.beginTransaction();
        session.save( new Gerente());
        session.getTransaction().commit();
    }

}
