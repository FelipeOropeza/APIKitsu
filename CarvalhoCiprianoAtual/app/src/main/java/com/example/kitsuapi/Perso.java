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

public class Perso extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private EditText nmPerso;
    private TextView nmNome;
    private TextView nmOrigem;
    private TextView nmApelido;
    private TextView nmMetas;
    private TextView nmPoder;
    private TextView nmFunc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso);
        nmPerso = findViewById(R.id.persoinput);
        nmNome = findViewById(R.id.nomeText);
        nmOrigem = findViewById(R.id.origemText);
        nmApelido = findViewById(R.id.apelidoText);
        nmMetas = findViewById(R.id.metasText);
        nmPoder = findViewById(R.id.poderText);
        nmFunc = findViewById(R.id.funcText);

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    public void buscarPerso(View view) {
        String queryString = nmPerso.getText().toString();
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
            nmNome.setText(R.string.str_empty);
            nmOrigem.setText(R.string.str_empty);
            nmApelido.setText(R.string.loading);
            nmMetas.setText(R.string.str_empty);
            nmPoder.setText(R.string.str_empty);
            nmFunc.setText(R.string.str_empty);
        }
        else {
            if (queryString.length() == 0) {
                nmNome.setText(R.string.str_empty);
                nmOrigem.setText(R.string.str_empty);
                nmApelido.setText(R.string.no_search_term);
                nmMetas.setText(R.string.str_empty);
                nmPoder.setText(R.string.str_empty);
                nmFunc.setText(R.string.str_empty);
            } else {
                nmNome.setText(R.string.str_empty);
                nmOrigem.setText(R.string.str_empty);
                nmApelido.setText(R.string.no_network);
                nmMetas.setText(R.string.str_empty);
                nmPoder.setText(R.string.str_empty);
                nmFunc.setText(R.string.str_empty);
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
        return new CarregaPerso(this, queryString);
    }

    public void TelaPrincipal(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String id) {
        try {
            JSONObject jsonObject = new JSONObject(id);
            JSONArray itemsArray = jsonObject.getJSONArray("id");
            int i = 0;
            String nome = null;
            String origem = null;
            String apelido = null;
            String metas = null;
            String poder = null;
            String func = null;
            while (i < itemsArray.length() &&
                    (nome == null && origem == null && apelido == null
                            && metas == null && poder == null && func == null)) {
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject attributes = book.getJSONObject("id");
                JSONObject idpoder = attributes.getJSONObject("poder");
                JSONObject idfunc = attributes.getJSONObject("func");
                try {
                    nome = attributes.getString("nome");
                    origem = attributes.getString("origem");
                    apelido = attributes.getString("apelido");
                    metas = attributes.getString("metas");
                    poder = idpoder.getString("resp");
                    func = idfunc.getString("tipoFunc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i++;
            }
            if (nome != null && origem != null) {
                nmNome.setText("Nome: " + nome);
                nmOrigem.setText("Origem: " + origem);
                nmApelido.setText("Apelido: " + apelido);
                nmMetas.setText("Metas: " + metas);
                nmPoder.setText("Respiracao: " + poder);
                nmFunc.setText("Funcao: " + func);
            } else {
                nmNome.setText(R.string.str_empty);
                nmOrigem.setText(R.string.str_empty);
                nmApelido.setText(R.string.no_results);
                nmMetas.setText(R.string.str_empty);
                nmPoder.setText(R.string.str_empty);
                nmFunc.setText(R.string.str_empty);
            }
        } catch (Exception e) {
            nmNome.setText(R.string.str_empty);
            nmOrigem.setText(R.string.str_empty);
            nmApelido.setText(R.string.no_results);
            nmMetas.setText(R.string.str_empty);
            nmPoder.setText(R.string.str_empty);
            nmFunc.setText(R.string.str_empty);
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}