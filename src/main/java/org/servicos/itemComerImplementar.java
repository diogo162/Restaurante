package org.servicos;

import org.example.Funcionario;
import org.example.HibernateUtil;
import org.example.ItemComer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class itemComerImplementar implements itemComerServico{

    HibernateUtil hu = new HibernateUtil();
    SessionFactory sessionFactory = hu.getSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public void listarCardapio() {
        List result = session.createQuery( "from ItemComer" ).list();
        for ( ItemComer Item : (List<ItemComer>) result ) {
            System.out.println( Item.getId_item() + " - " + Item.getNome() + " - " + Item.getValor() + " - " + Item.getIngrediente());
        }
    }
}
