package org.example.blackjack.Service;

import org.example.blackjack.DAO.CardDAOImpl;
import org.example.blackjack.model.Deck;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.json.JSONObject;

public class DeckService {
    CardDAOImpl cardDAO;

    public DeckService() {
        this.cardDAO = new CardDAOImpl();
    }


    public String[] guardarInformacionNasaApi(JSONObject jsonResponse) {

        String [] infoApi = new String [2];

        SessionFactory sessionFactory;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        try {
            System.out.println("aun tnego el objeto??");
            System.out.println(jsonResponse.toString());

            System.out.println("Id_Carta: "+jsonResponse.get("deck_id").toString());
            System.out.println("remaining: "+jsonResponse.get("remaining").toString());


            infoApi[0] = jsonResponse.get("deck_id").toString();
            infoApi[1] = jsonResponse.get("remaining").toString();

            System.out.println("Se guarda bien la info");
            for (int i = 0; i < infoApi.length; i++) {
                System.out.println(infoApi[i]);
            }





        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new RuntimeException(e);
        } finally {
            sessionFactory.close();
            return infoApi ;// Cerrar el SessionFactory al final
        }
    }

    public void saveDeck(Deck deck) {
        cardDAO.save(deck);
    }

    public Deck getDeckByid(String id) {

        Deck deck = cardDAO.findById(id);

        return deck;
    }
}
