package com.example.kitsuapi;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import android.widget.TextView;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        DbKitsu mydb = new DbKitsu(context);
        String mensagem = mydb.getUserName();

        if (mensagem == "No Results") {
            mensagem = "Venha conhecer mais sobre seus animes favoritos!";
        } else{
            mensagem = (mensagem + ", volte ao app!");
        }

        // // CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.appwidget_text, mensagem);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
//
//    @Override
//    public void onEnabled(Context context) {
//        super.onEnabled(context);
//        DbKitsu mydb = new DbKitsu(context);
//
//        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
//
//        String mensagem = mydb.getUserName();
//        views.setTextViewText(R.id.appwidget_text, mensagem);
//    }
//
    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
        super.onEnabled(context);
        DbKitsu mydb = new DbKitsu(context);
        String mensagem = mydb.getUserName();

        if (mensagem == "No Results") {
            mensagem = "Venha conhecer mais sobre seus animes favoritos!";
        } else{
            mensagem = (mensagem + ", venha conhecer mais sobre seus animes favoritos!");
        }

        // // CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.appwidget_text, mensagem);
    }
}