package com.example.ghiblifilms;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class DetailActivity extends Activity {
    private HashMap<String,String> traillers;
    private String currentFilm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        traillers = new HashMap<String, String>();
        currentFilm = "";
        SharedPreferences settings = getSharedPreferences("CURFILM", 0);
        settings.getString("currentFilm", currentFilm);
        loadFilmTrailer();
        webView(currentFilm);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void webView(String filmTitle){
        WebView webView;
        webView = (WebView) findViewById(R.id.trailler);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(traillers.get(filmTitle));
    }

    public void loadFilmTrailer(){
        traillers.put("spirited_away","https://www.youtube-nocookie.com/embed/5-cro68n7CE");
        traillers.put("arrietty","https://www.youtube.com/watch?v=RYwYgH9uA_8");
        traillers.put("castle_in_the_sky","https://www.youtube.com/watch?v=kqQxEe-tro0");
        traillers.put("from_up_on_poppy_hill","https://www.youtube.com/watch?v=tVnW2Dk4zdg");
        traillers.put("grave_of_the_fireflies","");
        traillers.put("howl_s_moving_castle","");
        traillers.put("kiki_s_delivery_service","");
        traillers.put("my_neighbor_totoro","");
        traillers.put("my_neighbors_the_yamadas","");
        traillers.put("only_yesterday","");
        traillers.put("pom_poko","");
        traillers.put("ponyo","");
        traillers.put("porco_rosso","");
        traillers.put("princess_mononoke","");
        traillers.put("tales_from_earthsea","");
        traillers.put("the_cat_returns","");
        traillers.put("the_tale_of_the_princess_kaguya","");
        traillers.put("the_wind_rises","");
        traillers.put("when_marnie_was_there","");
        traillers.put("whisper_of_the_heart","");
    }
}
