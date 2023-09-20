package com.example.kitsuapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private EditText nmLivro;
    private TextView nmTitulo;
    private TextView nmAutor;
    private TextView nmEp;
    private TextView nmTemp;
    private TextView nmSin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nmLivro = findViewById(R.id.animeinput);
        nmTitulo = findViewById(R.id.tituloText);
        nmAutor = findViewById(R.id.autorText);
        nmEp = findViewById(R.id.epText);
        nmTemp = findViewById(R.id.tempsText);
        nmSin = findViewById(R.id.sinText);
        TextView usermsg = findViewById(R.id.usergreetings);
        DbKitsu mydb = new DbKitsu(this);
        String message = ("Olá " + mydb.getUserName());
        usermsg.setText(message);

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    public void buscaAnimes(View view) {
        String queryString = nmLivro.getText().toString();
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);
            nmAutor.setText(R.string.str_empty);
            nmEp.setText(R.string.str_empty);
            nmTemp.setText(R.string.str_empty);
            nmSin.setText(R.string.str_empty);
            nmTitulo.setText(R.string.loading);
        }
        else {
            if (queryString.length() == 0) {
                nmTitulo.setText(R.string.no_search_term);
                nmAutor.setText(R.string.str_empty);
                nmEp.setText(R.string.str_empty);
                nmTemp.setText(R.string.str_empty);
                nmSin.setText(R.string.str_empty);
            } else {
                nmTitulo.setText(R.string.no_network);
                nmAutor.setText(" ");
                nmEp.setText(R.string.str_empty);
                nmTemp.setText(R.string.str_empty);
                nmSin.setText(R.string.str_empty);
            }
        }
    }
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";
        if (args != null) {
            queryString = args.getString("queryString");
        }
        return new CarregaAnime(this, queryString);
    }
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("data");
            int i = 0;
            String tituloEn = null;
            String tituloJa = null;
            String ep = null;
            String ava = null;
            String sin = null;
            while (i < itemsArray.length() &&
                    (tituloJa == null && tituloEn == null && ep == null
                            && ava == null && sin == null)) {
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject attributes = book.getJSONObject("attributes");
                JSONObject titles = attributes.getJSONObject("titles");
                try {
                    tituloEn = titles.getString("en");
                    tituloJa = titles.getString("ja_jp");
                    ep = attributes.getString("episodeCount");
                    ava = attributes.getString("averageRating");
                    sin = attributes.getString("synopsis");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i++;
            }
            if (tituloEn != null && tituloJa != null) {
                nmTitulo.setText("Titulo em ingles: " + tituloEn);
                nmAutor.setText("Titulo em japones: " + tituloJa);
                nmEp.setText("Numero de episodios: " + ep);
                nmTemp.setText("Avaliacao: " + ava);
                nmSin.setText("Sinopse: " + sin);
            } else {
                nmTitulo.setText(R.string.no_results);
                nmAutor.setText(R.string.str_empty);
                nmEp.setText(R.string.str_empty);
                nmTemp.setText(R.string.str_empty);
                nmSin.setText(R.string.str_empty);
            }
        } catch (Exception e) {
            nmTitulo.setText(R.string.no_results);
            nmAutor.setText(R.string.str_empty);
            nmEp.setText(R.string.str_empty);
            nmTemp.setText(R.string.str_empty);
            nmSin.setText(R.string.str_empty);
            e.printStackTrace();
        }
    }
    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
    }

    public void AcessaCadastro(View view){
        Intent intent = new Intent(this, cadastro.class);
        startActivity(intent); //Abre a segunda activity
    }

    public void AcessaPerso(View view){
        Intent intent = new Intent(this, Perso.class);
        startActivity(intent); //Abre a segunda activity
    }
}


