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

public class HotelsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(this.getString(R.string.hotel_bonjour),
                this.getString(R.string.hotel_bonjour_type),
                this.getString(R.string.hotel_bonjour_address),
                this.getString(R.string.hotel_bonjour_phone),
                this.getString(R.string.hotel_bonjour_url),
                this.getString(R.string.hotel_bonjour_open_hours),
                this.getString(R.string.hotel_bonjour_fees),
                this.getString(R.string.hotel_bonjour_description)));
        places.add(new Place(this.getString(R.string.hotel_record),
                this.getString(R.string.hotel_record_type),
                this.getString(R.string.hotel_record_address),
                this.getString(R.string.hotel_record_phone),
                this.getString(R.string.hotel_record_url),
                this.getString(R.string.hotel_record_open_hours),
                this.getString(R.string.hotel_record_fees),
                this.getString(R.string.hotel_record_description)));
        places.add(new Place(this.getString(R.string.hotel_mikron),
                this.getString(R.string.hotel_mikron_type),
                this.getString(R.string.hotel_mikron_address),
                this.getString(R.string.hotel_mikron_phone),
                this.getString(R.string.hotel_mikron_url),
                this.getString(R.string.hotel_mikron_open_hours),
                this.getString(R.string.hotel_mikron_fees),
                this.getString(R.string.hotel_mikron_description)));
        places.add(new Place(this.getString(R.string.hotel_stay),
                this.getString(R.string.hotel_stay_type),
                this.getString(R.string.hotel_stay_address),
                this.getString(R.string.hotel_stay_phone),
                this.getString(R.string.hotel_stay_url),
                this.getString(R.string.hotel_stay_open_hours),
                this.getString(R.string.hotel_stay_fees),
                this.getString(R.string.hotel_stay_description)));
        places.add(new Place(this.getString(R.string.hotel_andreevka),
                this.getString(R.string.hotel_andreevka_type),
                this.getString(R.string.hotel_andreevka_address),
                this.getString(R.string.hotel_andreevka_phone),
                this.getString(R.string.hotel_andreevka_url),
                this.getString(R.string.hotel_andreevka_open_hours),
                this.getString(R.string.hotel_andreevka_fees),
                this.getString(R.string.hotel_andreevka_description)));

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
