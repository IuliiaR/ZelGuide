package com.example.android.zelguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SightsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(this.getString(R.string.sight_victory),
                this.getString(R.string.sight_victory_type),
                this.getString(R.string.sight_victory_address),
                "",
                this.getString(R.string.sight_victory_url),
                this.getString(R.string.sight_victory_open_hours),
                this.getString(R.string.sight_victory_fees),
                this.getString(R.string.sight_victory_description),
                R.drawable.park_victory));
        places.add(new Place(this.getString(R.string.sight_dk),
                this.getString(R.string.sight_dk_type),
                this.getString(R.string.sight_dk_address),
                this.getString(R.string.sight_dk_phone),
                this.getString(R.string.sight_dk_url),
                this.getString(R.string.sight_dk_open_hours),
                "",
                this.getString(R.string.sight_dk_description),
                R.drawable.dk));
        places.add(new Place(this.getString(R.string.sight_fleita),
                this.getString(R.string.sight_fleita_type),
                this.getString(R.string.sight_fleita_address),
                "",
                this.getString(R.string.sight_fleita_url),
                this.getString(R.string.sight_fleita_open_hours),
                this.getString(R.string.sight_fleita_fees),
                this.getString(R.string.sight_fleita_description),
                R.drawable.fleita));
        places.add(new Place(this.getString(R.string.sight_rubezh),
                this.getString(R.string.sight_rubezh_type),
                this.getString(R.string.sight_rubezh_address),
                this.getString(R.string.sight_rubezh_phone),
                this.getString(R.string.sight_rubezh_url),
                this.getString(R.string.sight_rubezh_open_hours),
                this.getString(R.string.sight_rubezh_fees),
                this.getString(R.string.sight_rubezh_description),
                R.drawable.shtyki));
        places.add(new Place(this.getString(R.string.sight_serednikovo),
                this.getString(R.string.sight_serednikovo_type),
                this.getString(R.string.sight_serednikovo_address),
                this.getString(R.string.sight_serednikovo_phone),
                this.getString(R.string.sight_serednikovo_url),
                this.getString(R.string.sight_serednikovo_open_hours),
                this.getString(R.string.sight_serednikovo_fees),
                this.getString(R.string.sight_serednikovo_description),
                R.drawable.serednikovo));
        places.add(new Place(this.getString(R.string.sight_lani),
                this.getString(R.string.sight_lani_type),
                this.getString(R.string.sight_lani_address),
                this.getString(R.string.sight_lani_phone),
                this.getString(R.string.sight_lani_url),
                this.getString(R.string.sight_lani_open_hours),
                this.getString(R.string.sight_lani_fees),
                this.getString(R.string.sight_lani_description),
                R.drawable.dom_lani));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView list = rootView.findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = view.getContext();
                Intent myIntent = new Intent(context, DetailsActivity.class);
                myIntent.putExtra("PLACE", places.get(i));
                context.startActivity(myIntent);
            }
        });

        return rootView;
    }
}
