package org.example.blackjack.DAO;

import org.example.blackjack.model.Card;
import org.example.blackjack.model.Deck;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CardDAOImpl {
    SessionFactory myFactory;

    public CardDAOImpl() {

        System.out.println("creando objeto");
        // TODO AQUI ESTA EL ERROR
        this.myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Card.class).buildSessionFactory();

    }

    public void save(Deck deck) {
        Session miSession = myFactory.openSession();

        try {

            miSession.beginTransaction();
            miSession.save(deck);
            miSession.getTransaction().commit();
            System.out.println("Insert correctamente");


        } catch (Exception e) {
            System.out.println("Error al insertar");
            System.out.println("Se ha producido un error");
            if (miSession != null && miSession.getTransaction() != null) {
                miSession.getTransaction().rollback(); // Revertir la transacción en caso de error
            }

        } finally {
            miSession.close();


        }
    }

    public Deck findById(String idDeck) {
        Session miSession = myFactory.openSession();
        Deck deck = null;
        try {
            // comenzar sesion
            miSession.beginTransaction();


            // para obtener un dato u otro ||
            deck = miSession.createQuery("from decks as1 where as1.id = :id", Deck.class)
                    .setParameter("id", idDeck)
                    .uniqueResult();

            // cuando habre session tienes que poner un commit
            miSession.getTransaction().commit();


        } catch (Exception e) {
            System.out.println("Se ha producido un error");
            if (miSession != null && miSession.getTransaction() != null) {
                miSession.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            throw new RuntimeException(e);
        } finally {
            // luego tienes que cerrar la sesion
            miSession.close();
        }
        return deck;

    }

}
