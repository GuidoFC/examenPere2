package org.example.blackjack.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.blackjack.Service.DeckService;
import org.example.blackjack.api.ApiDeck;
import org.example.blackjack.model.Deck;
import org.json.JSONObject;
import java.io.IOException;

@WebServlet(
//        Nombre del Servlet
        name = "cardServletCrear",
        // indica que este servlet responderá cuando alguien visite la URL /movie en el servidor.
        urlPatterns = "/crear")

public class DeckSerlvertCrear extends HttpServlet {


    private DeckService cardService = new DeckService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Estoy en AsteroideServletCrear CREAR!!! DoGet");



            try {

                ApiDeck apiDeck = new ApiDeck();
                // Todo tengo que coger por el html lo que me envia y ponerlo en numeroBarjas!!!
                int numeroBarjas = 3;
                JSONObject jsonResponse = apiDeck.getDeckFromApi(numeroBarjas);
                System.out.println("Que cojo??");
                System.out.println(jsonResponse.toString());


                // TODO tengo que decir cuantas cartas quiero
                String [] infoApi =   cardService.guardarInformacionNasaApi(jsonResponse);
                System.out.println("Info recuperada de la API!!!");
                System.out.println(infoApi[0]);
                System.out.println(infoApi[1]);
                Deck deck = new Deck();
                deck.setId(infoApi[0]);
                deck.setRemaining(Integer.parseInt(infoApi[1]));
                cardService.saveDeck(deck);

                request.setAttribute("deck", deck);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index2.jsp");
                System.out.println("processRequest de DeckSerlvet 23");
                dispatcher.forward(request, response);



            } catch (Exception e) {
                e.printStackTrace();
            }


            processRequest(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        List<Asteroide> listaAsteroide = cardService.getListAsteroideFromService();
        //
//        request.setAttribute("listaAsteroide", listaAsteroide);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index2.jsp");
        dispatcher.forward(request, response);
    }
}
