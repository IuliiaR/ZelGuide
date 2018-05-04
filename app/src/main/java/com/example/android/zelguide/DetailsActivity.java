package com.example.android.zelguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public static final String CHOSEN_PLACE = "PLACE";
    private Place place;
    private Context mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_details);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //collect the transferred data from the previous activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            place = bundle.getParcelable(CHOSEN_PLACE);
        }

        ImageView image = findViewById(R.id.place_image_view);
        CollapsingToolbarLayout title = findViewById(R.id.place_title_view);
        TextView description = findViewById(R.id.description);
        TextView phone = findViewById(R.id.phone);
        TextView url = findViewById(R.id.url);
        TextView openHours = findViewById(R.id.open_hours);
        TextView fee = findViewById(R.id.fee);

        image.setImageResource(place.getImageId());
        title.setTitle(place.getName());
        description.setText(place.getDescription());
        phone.setText(place.getPhone());
        url.setText(place.getUrl());
        openHours.setText(place.getOpenHours());
        fee.setText(place.getFees());

        final FloatingActionButton mapButton = findViewById(R.id.map_floating_action_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(place.getAddress()));
                startActivity(i);
            }
        });
    }
}
