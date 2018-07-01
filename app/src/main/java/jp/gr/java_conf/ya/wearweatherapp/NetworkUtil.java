package jp.gr.java_conf.ya.wearweatherapp; //  Copyright (c) 2018 YA<ya.androidapp@gmail.com> All rights reserved.

import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class NetworkUtil {
    public static Document getDocument(final String uri){
        try {
            Connection connection = Jsoup.connect(uri);
            Document doc = connection.get();
            return doc;
        } catch (IOException e) {
            Log.d("WWA", e.toString());
        } catch (Exception e) {
            Log.d("WWA", e.toString());
        }

        return null;
    }
}
