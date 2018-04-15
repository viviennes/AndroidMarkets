package com.example.weronika.shops;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Weronika on 15.04.2018.
 */

public class ListArrayAdapter extends ArrayAdapter<Market> {

    private final Context context;
    private final List<Market>  markets;

    public ListArrayAdapter(@NonNull Context context, List<Market> markets) {
        super(context, -1, markets);
        this.context = context;
        this.markets = markets;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView firstLine = rowView.findViewById(R.id.firstLine);
        TextView secondLine = rowView.findViewById(R.id.secondLine);
        firstLine.setText(markets.get(position).getInstrumentName());
        secondLine.setText(markets.get(position).getDisplayOffer());

        return rowView;
    }
}

