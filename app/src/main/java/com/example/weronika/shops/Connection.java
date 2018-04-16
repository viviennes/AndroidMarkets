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


public class Connection extends AsyncTask<String, Void, Void> {

    private FetchData fetchData;

    public FetchData getFetchData() {
        return fetchData;
    }

    @Override
    protected Void doInBackground(String... strings) {

        String country = strings[0];
        String urlName = setURL(country);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            fetchData = objectMapper.readValue(getData(urlName), FetchData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getData(String urlName){

        String data = "";

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
        } catch (MalformedURLException e ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private String setURL(String country){
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
        return urlName;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

}
