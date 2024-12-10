package org.example.blackjack.DAO;

import org.example.blackjack.model.Card;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CardDAOImpl {
    SessionFactory myFactory;

    public CardDAOImpl() {

        System.out.println("creando objeto");
        // TODO AQUI ESTA EL ERROR
        this.myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Card.class).buildSessionFactory();

    }
}
