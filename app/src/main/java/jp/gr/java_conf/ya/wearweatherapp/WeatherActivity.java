package jp.gr.java_conf.ya.wearweatherapp; //  Copyright (c) 2018 YA<ya.androidapp@gmail.com> All rights reserved.

import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeatherActivity extends WearableActivity {

    private String URI_SITE = "jma";
    private String URI_ID = "319";
    private String URI = "https://www."+URI_SITE+".go.jp/jp/week/"+URI_ID+".html";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mTextView = findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();

        init();
    }

    Handler handler = new Handler();

    private void init() {
        new Thread(new Runnable() {
            @Override
            public final void run() {
                final Document doc = NetworkUtil.getDocument(URI);
//                Elements elements = doc.select("table#infotablefont tr td");
//                for (Element element : elements) {
//                    Log.v("WWA",element.outerHtml());
//                }
                if (doc != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mTextView.setText(doc.title());
                        }
                    });
                }
            }
        }).start();
    }
}
