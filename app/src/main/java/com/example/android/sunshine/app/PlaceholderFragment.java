package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by erickson on 01/01/17.
 */

public class PlaceholderFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView detailTextView = (TextView) rootView.findViewById(R.id.detail_textview);

        String text = getActivity().getIntent().getExtras().getString(ForecastFragment.FORECAST_DETAIL);

        detailTextView.setText(text);

        return rootView;
    }
}
