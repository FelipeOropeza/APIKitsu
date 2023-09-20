package com.example.kitsuapi;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class CarregaPerso extends AsyncTaskLoader<String> {
    private String mQueryString;
    CarregaPerso(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return PersoNetworkWidget.buscaInfosPerso(mQueryString);
    }
}