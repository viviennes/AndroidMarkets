package com.example.weronika.shops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.countries_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries_list,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Spinner spinner = findViewById(R.id.countries_spinner);
        ListView listView = findViewById(R.id.markets_list_view);
        Connection connection = new Connection();
        try {
            connection.execute(spinner.getSelectedItem().toString()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(connection.fetchData != null){
            List<Market> marketList = connection.fetchData.getMarkets();

            if (marketList.size() > 0) {
                Collections.sort(marketList, (object1, object2) -> object1.getInstrumentName().compareTo(object2.getInstrumentName()));
            }

            ListArrayAdapter listArrayAdapter = new ListArrayAdapter(this, marketList);
            listView.setAdapter(listArrayAdapter);
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
