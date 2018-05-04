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

public class EntertainmentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(this.getString(R.string.entertainment_panda),
                this.getString(R.string.entertainment_panda_type),
                this.getString(R.string.entertainment_panda_address),
                this.getString(R.string.entertainment_panda_phone),
                this.getString(R.string.entertainment_panda_url),
                this.getString(R.string.entertainment_panda_open_hours),
                this.getString(R.string.entertainment_panda_fees),
                this.getString(R.string.entertainment_panda_description)));
        places.add(new Place(this.getString(R.string.entertainment_vedogon),
                this.getString(R.string.entertainment_vedogon_type),
                this.getString(R.string.entertainment_vedogon_address),
                this.getString(R.string.entertainment_vedogon_phone),
                this.getString(R.string.entertainment_vedogon_url),
                this.getString(R.string.entertainment_vedogon_open_hours),
                this.getString(R.string.entertainment_vedogon_fees),
                this.getString(R.string.entertainment_vedogon_description)));
        places.add(new Place(this.getString(R.string.entertainment_quest),
                this.getString(R.string.entertainment_quest_type),
                this.getString(R.string.entertainment_quest_address),
                this.getString(R.string.entertainment_quest_phone),
                this.getString(R.string.entertainment_quest_url),
                this.getString(R.string.entertainment_quest_open_hours),
                this.getString(R.string.entertainment_quest_fees),
                this.getString(R.string.entertainment_quest_description)));
        places.add(new Place(this.getString(R.string.entertainment_shtos),
                this.getString(R.string.entertainment_shtos_type),
                this.getString(R.string.entertainment_shtos_address),
                this.getString(R.string.entertainment_shtos_phone),
                this.getString(R.string.entertainment_shtos_url),
                this.getString(R.string.entertainment_shtos_open_hours),
                this.getString(R.string.entertainment_shtos_fees),
                this.getString(R.string.entertainment_shtos_description)));
        places.add(new Place(this.getString(R.string.entertainment_iridium),
                this.getString(R.string.entertainment_iridium_type),
                this.getString(R.string.entertainment_iridium_address),
                this.getString(R.string.entertainment_iridium_phone),
                this.getString(R.string.entertainment_iridium_url),
                this.getString(R.string.entertainment_iridium_open_hours),
                this.getString(R.string.entertainment_iridium_fees),
                this.getString(R.string.entertainment_iridium_description)));

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
