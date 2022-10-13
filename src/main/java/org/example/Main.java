package org.example;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String args[]) {
        HibernateUtil hu = new HibernateUtil();
        SessionFactory sessionFactory = hu.getSessionFactory();
        Session session = sessionFactory.openSession();
        Scanner senha = new Scanner(System.in);

        System.out.println("Bem-vindo, digite sua senha");
        String gerenteSenha = senha.nextLine();

        if(gerenteSenha == "true"){
            logar();
        }
        else{
            System.out.println("senha incorreta");
        }
        session.close();
        sessionFactory.close();
    }

    private static void logar() {
    }
}
