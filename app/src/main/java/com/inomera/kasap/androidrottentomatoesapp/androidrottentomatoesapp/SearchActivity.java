package com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import com.inomera.kasap.androidrottentomatoesapp.R;

/**
 * Created by Menaf on 09.07.2015
 */
public class SearchActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    private void doMySearch(String query) {
        showToast(query);
    }

}
