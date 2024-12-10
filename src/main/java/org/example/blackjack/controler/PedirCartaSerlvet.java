package org.example.blackjack.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.blackjack.Service.DeckService;
import org.example.blackjack.model.Deck;

import java.io.IOException;

@WebServlet(
//        Nombre del Servlet
        name = "cardServletCrear",
        // indica que este servlet responderá cuando alguien visite la URL /movie en el servidor.
        urlPatterns = "/pedirCartas")

public class PedirCartaSerlvet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Estoy en MovieSerlet CREAR!!! DoPost");

            // recueperar el deck de mi base de datos
        Deck deck = new Deck();
         DeckService cardService = new DeckService();
         deck = cardService.getDeckByid(request.getParameter("id"));


            Long numCartas = Long.parseLong(request.getParameter("numberOfDecks"));

// pedir una peticion a la nasa

        // crear cartas para enviarla al html



        }
    }
}
