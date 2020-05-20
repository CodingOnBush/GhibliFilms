package com.example.ghiblifilms;

import android.view.View;
import android.webkit.WebView;

import java.util.HashMap;

public class DetailController {
    public HashMap<String,String> videos;
    DetailActivity detailActivity;

    public DetailController(DetailActivity detailActivity) {
        this.detailActivity = detailActivity;
    }

    public void onStart(){
        videos = new HashMap<String, String>();
        videos.put("Kurorko","<iframe src=\"https://drive.google.com/file/d/1w2blWS1OSLlLMHjOK13fW0RSy0aO_TlW/preview\" width=\"640\" height=\"480\"></iframe>");
        WebView view;
        view = (WebView) detailActivity.findViewById(R.id.trailler);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.loadUrl(videos.get("Kurorko"));
            }
        });
    }
}
