package com.example.weronika.shops;

import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Weronika on 14.04.2018.
 */

public class Connection extends AsyncTask<String, Void, Void> {

    String data = "";
    FetchData fetchData;

    @Override
    protected Void doInBackground(String... strings) {
        String country = strings[0];
        String urlName = "https://api.ig.com/deal/samples/markets/ANDROID_PHONE/";
        switch (country) {

            case "DE":
                urlName += "de_DE/dem";
                break;
            case "FR":
                urlName += "fr_FR/frm";
                break;
            case "UK":
            default:
                urlName += "en_GB/igi";
                break;
        }


        try {
            URL url = new URL(urlName);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while (line != null) {
                line = bufferedReader.readLine();
                data += line;
            }

        } catch (MalformedURLException e) {
            //TODO zrobic z tym porządek
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            fetchData = objectMapper.readValue(data, FetchData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

}
