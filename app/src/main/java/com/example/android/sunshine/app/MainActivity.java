package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getActivity()
                    , R.layout.list_item_forecast
                    , R.id.list_item_forecast_textview
                    , getForeCastListData()
            );

            ListView forecastListView = (ListView) rootView.findViewById(R.id.listview_forecast);

            forecastListView.setAdapter(adapter);

            return rootView;
        }

        private List<String> getForeCastListData() {
            List<String> mockedData = new ArrayList<>();

            mockedData.add("Today - Sunny - 88/83");
            mockedData.add("Tomorrow - Foggy - 70/46");
            mockedData.add("Weds - Cloudy - 72/63");
            mockedData.add("Thurs - Rainy - 64/51");
            mockedData.add("Fri - Foggy - 70/46");
            mockedData.add("Sat - Sunny - 76/68");

            return mockedData;
        }
    }
}
