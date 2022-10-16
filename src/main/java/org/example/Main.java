package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.servicos.*;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        HibernateUtil hu = new HibernateUtil();
        SessionFactory sessionFactory = hu.getSessionFactory();
        Session session = sessionFactory.openSession();
        gerenteServico Gerente = new gerenteImplementar();
        Scanner senha = new Scanner(System.in);


//        Gerente.criarGerente("123456", "Marcelo", 819823448, "1523");
        System.out.println("Bem-vindo, digite sua senha");
        String gerenteSenha = senha.nextLine();
        Gerente.verificarSenha(gerenteSenha);
        if(Objects.equals(gerenteSenha, "123")){
            Gerente.logar();

        }
        else{
            System.out.println("senha incorreta, tente novamente");
        }
        session.close();
        sessionFactory.close();
    }

}
