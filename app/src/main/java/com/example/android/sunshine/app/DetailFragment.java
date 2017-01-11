package com.example.android.sunshine.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by erickson on 01/01/17.
 */

public class DetailFragment extends Fragment {

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    private static final String FORECAST_SHARE_HASHTAG = "#SunshineApp";

    private String mForecastStr;

    private ShareActionProvider mShareActionProvider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView detailTextView = (TextView) rootView.findViewById(R.id.detail_textview);

        mForecastStr = getActivity().getIntent().getExtras().getString(ForecastFragment.FORECAST_DETAIL);

        detailTextView.setText(mForecastStr);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detailfragment, menu);

        MenuItem menuItem = menu.findItem(R.id.action_share);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
            setShareIntent(createShareIntent());
        }

    }

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                mShareActionProvider.setShareIntent(shareIntent);
            }
        }
    }

    private Intent createShareIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,
                mForecastStr + FORECAST_SHARE_HASHTAG);
        return shareIntent;
    }
}
