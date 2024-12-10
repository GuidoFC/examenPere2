package org.example.blackjack.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.blackjack.Service.CardService;
import org.example.blackjack.api.ApiCard;
import org.json.JSONObject;
import java.io.IOException;
import java.util.List;

@WebServlet(
//        Nombre del Servlet
        name = "cardServletCrear",
        // indica que este servlet responderá cuando alguien visite la URL /movie en el servidor.
        urlPatterns = "/crear")

public class CardSerlvertCrear  extends HttpServlet {


    private CardService cardService = new CardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Estoy en AsteroideServletCrear CREAR!!! DoGet");



            try {
                // TODO tengo que decir cuantas cartas quiero
                ApiCard apiCard = new ApiCard(2);
                JSONObject jsonResponse = apiCard.getNasaApi();
                System.out.println("Que cojo??");
                System.out.println(jsonResponse.toString());



                String [] infoApi =   cardService.guardarInformacionNasaApi(jsonResponse);
                System.out.println("Ya casi esta");
                System.out.println(infoApi[0]);
                System.out.println(infoApi[1]);



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
