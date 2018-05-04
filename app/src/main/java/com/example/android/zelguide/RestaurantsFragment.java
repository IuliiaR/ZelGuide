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

public class RestaurantsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(this.getString(R.string.restaurant_dodo),
                this.getString(R.string.restaurant_dodo_type),
                this.getString(R.string.restaurant_dodo_address),
                this.getString(R.string.restaurant_dodo_phone),
                this.getString(R.string.restaurant_dodo_url),
                this.getString(R.string.restaurant_dodo_open_hours),
                this.getString(R.string.restaurant_dodo_fees),
                this.getString(R.string.restaurant_dodo_description)));
        places.add(new Place(this.getString(R.string.restaurant_temple),
                this.getString(R.string.restaurant_temple_type),
                this.getString(R.string.restaurant_temple_address),
                this.getString(R.string.restaurant_temple_phone),
                this.getString(R.string.restaurant_temple_url),
                this.getString(R.string.restaurant_temple_open_hours),
                this.getString(R.string.restaurant_temple_fees),
                this.getString(R.string.restaurant_temple_description)));
        places.add(new Place(this.getString(R.string.restaurant_tanuki),
                this.getString(R.string.restaurant_tanuki_type),
                this.getString(R.string.restaurant_tanuki_address),
                this.getString(R.string.restaurant_tanuki_phone),
                this.getString(R.string.restaurant_tanuki_url),
                this.getString(R.string.restaurant_tanuki_open_hours),
                this.getString(R.string.restaurant_tanuki_fees),
                this.getString(R.string.restaurant_tanuki_description)));
        places.add(new Place(this.getString(R.string.restaurant_dikanka),
                this.getString(R.string.restaurant_dikanka_type),
                this.getString(R.string.restaurant_dikanka_address),
                this.getString(R.string.restaurant_dikanka_phone),
                this.getString(R.string.restaurant_dikanka_url),
                this.getString(R.string.restaurant_dikanka_open_hours),
                this.getString(R.string.restaurant_dikanka_fees),
                this.getString(R.string.restaurant_dikanka_description)));
        places.add(new Place(this.getString(R.string.restaurant_mcdonalds),
                this.getString(R.string.restaurant_mcdonalds_type),
                this.getString(R.string.restaurant_mcdonalds_address),
                this.getString(R.string.restaurant_mcdonalds_phone),
                this.getString(R.string.restaurant_mcdonalds_url),
                this.getString(R.string.restaurant_mcdonalds_open_hours),
                this.getString(R.string.restaurant_mcdonalds_fees),
                this.getString(R.string.restaurant_mcdonalds_description)));

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
