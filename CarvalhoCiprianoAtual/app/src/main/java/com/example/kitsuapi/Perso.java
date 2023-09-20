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
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        // Termina
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}