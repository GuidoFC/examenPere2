package org.example.blackjack.Service;

import org.example.blackjack.DAO.CardDAOImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Date;

public class CardService {
    CardDAOImpl cardDAO;

    public CardService() {
        this.cardDAO = new CardDAOImpl();
    }


    public void guardarInformacionNasaApi(JSONObject jsonResponse) {

        SessionFactory sessionFactory;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        try {

            JSONArray nearEarthObjects = jsonResponse.getJSONArray("near_earth_objects");

        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new RuntimeException(e);
        } finally {
            sessionFactory.close();  // Cerrar el SessionFactory al final
        }
    }
}
