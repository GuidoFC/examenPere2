package org.example.blackjack.api;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCard {
    private int numBarajar;


    public ApiCard(int numBarajar) {
        this.numBarajar = numBarajar;
    }

    public JSONObject getNasaApi() throws IOException {
//        todo
// "https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=" + this.numBarajar
        URL url = new URL("https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response1 = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response1.append(line);
            }
            reader.close();
            connection.disconnect();
            return new JSONObject(response1.toString());
        }else {
            connection.disconnect();
            return null;
        }

    }
}
