package com.androidbuts.fawad.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.androidbuts.fawad.R;
import com.androidbuts.fawad.adapter.VodTabsAdapter;
import com.androidbuts.fawad.model.VodTab;
import com.androidbuts.fawad.model.VodTabList;
import com.androidbuts.fawad.retrofit.api.ApiService;
import com.androidbuts.fawad.retrofit.api.RetroClient;
import com.androidbuts.fawad.utils.InternetConnection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fawadjawaidmalik on 13/10/2016.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Views
     */
    private ListView listView;
    private View parentView;

    private ArrayList<VodTab> vodTabList;
    private VodTabsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Array List for Binding Data from JSON to this List
         */
        vodTabList = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);

        /**
         * Checking Internet Connection
         */
        if (InternetConnection.checkConnection(getApplicationContext())) {
            final ProgressDialog dialog;
            /**
             * Progress Dialog for User Interaction
             */
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle(getString(R.string.string_getting_VODTabs_title));
            dialog.setMessage(getString(R.string.string_getting_VODTabs_message));
            dialog.show();

            //Creating an object of our api interface
            ApiService api = RetroClient.getApiService();

            /**
             * Calling getVODTabs
             */
            Call<VodTabList> call = api.getVODTabs();

            /**
             * Enqueue Callback will be call when get response...
             */
            call.enqueue(new Callback<VodTabList>() {
                @Override
                public void onResponse(Call<VodTabList> call, Response<VodTabList> response) {
                    //Dismiss Dialog
                    dialog.dismiss();

                    if(response.isSuccessful()) {
                        /**
                         * Got Successfully
                         */
                        vodTabList = response.body().getVODTabs();

                        /**
                         * Binding that List to Adapter
                         */
                        adapter = new VodTabsAdapter(MainActivity.this, vodTabList);
                        listView.setAdapter(adapter);

                    } else {
                        Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<VodTabList> call, Throwable t) {
                    dialog.dismiss();
                }
            });

        } else {
            Snackbar.make(parentView, R.string.string_internet_connection_not_available, Snackbar.LENGTH_LONG).show();
        }
    }
}