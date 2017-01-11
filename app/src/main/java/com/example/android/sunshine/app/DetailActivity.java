package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;

public class DetailActivity extends SunshineActivity {

    ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_detail, new DetailFragment())
                    .commit();
        }
    }

}
