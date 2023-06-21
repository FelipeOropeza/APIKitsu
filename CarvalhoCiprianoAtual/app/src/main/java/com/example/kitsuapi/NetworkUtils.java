package com.example.kitsuapi;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {

    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    private static final String ANIME_URL = "https://kitsu.io/api/edge/anime?";

    private static final String QUERY_PARAM = "filter[text]";

    private static final String MAX_RESULTS = "page[limit]";

    static String buscaInfosAnime(String queryString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String animeJSONString = null;
        try {
            Uri builtURI = Uri.parse(ANIME_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "3")
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
            animeJSONString = builder.toString();
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
        Log.d(LOG_TAG, animeJSONString);
        return animeJSONString;
    }
}
