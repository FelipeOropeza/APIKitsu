package com.example.kitsuapi;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PersoNetworkWidget {
    private static final String LOG_TAG = PersoNetworkWidget.class.getSimpleName();

    private static final String PERSO_URL = "Url APi Perso";

    private static final String QUERY_PARAM = "nome";

    static String buscaInfosPerso(String queryString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String persoJSONString = null;
        try {
            Uri builtURI = Uri.parse(PERSO_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .build();
            URL requestURL = new URL(builtURI.toString());
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            int response = urlConnection.getResponseCode();
            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null){
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0){
                return null;
            }
            persoJSONString = builder.toString();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            if (reader != null) {
                try{
                    reader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        Log.d(LOG_TAG, persoJSONString);
        return persoJSONString;
    }
}
