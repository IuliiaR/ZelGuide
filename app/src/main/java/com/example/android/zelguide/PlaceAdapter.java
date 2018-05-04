package com.example.android.zelguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {
    private Context mContext;
    public PlaceAdapter(@NonNull Context context, ArrayList<Place> places) {
        super(context, 0, places);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Place currentPlace = getItem(position);

        View layout = listItemView.findViewById(R.id.card_info_container);

        TextView placeName = layout.findViewById(R.id.place_name);
        placeName.setText(currentPlace.getName());

        TextView placeType = layout.findViewById(R.id.info_text);
        placeType.setText(currentPlace.getType());

        ImageView image = layout.findViewById(R.id.place_image);
        if (currentPlace.getImageId() == 0){
            image.setVisibility(View.GONE);
            placeName.setTextColor(mContext.getResources().getColor(R.color.textColorPrimary));
            placeType.setTextColor(mContext.getResources().getColor(R.color.textColorSecondary));
        }
        else {
            image.setImageResource(currentPlace.getImageId());
        }

        return listItemView;
    }
}
