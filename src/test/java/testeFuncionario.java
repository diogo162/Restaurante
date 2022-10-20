import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.example.Funcionario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import org.example.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;



public class TesteFuncionario {

    private HibernateUtil hu;
    EntityManager em;





    @Before
    public void setUp() throws Exception {
        hu = new HibernateUtil();
        em = hu.getEntityManager();
    }



    @Test
    public void testaFuncionario{
        em.getTransaction().begin();

        Funcionario f1 = new Funcionario();

        f1.setNome(nome: "funcionario_teste_1");
        f1.setCpf(cpf: "12345678901");

        em.persist(f1);


        em.getTransaction().commit()


        Query q = em.CreateQuery(qlString:"select c from Cliente c where c.cpf=:cpf");
        q.setParameter(name: "cpf" , value: "12345678901");
        Funcionario retorno = (funcionario) q.getSingleResult();

        assertEquals(retorno.getCpf(), actual: "12345678901");
    }

    @After
    public void tearDown() throws Exception{
        em.close();
        hu.tearDown();
    }
}