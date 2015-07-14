package com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.common.adapters.DataAdapter;
import com.inomera.kasap.androidrottentomatoesapp.network.models.MovieResponse;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

/**
 * Created by Menaf on 09.07.2015
 */
public class SearchActivity extends BaseActivity {

    Toolbar toolbar;
    protected static final String LAYOUT_TYPE_LINEAR = "linear";
    protected RecyclerView mRecyclerView;
    protected DataAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Creating The Toolbar and setting it as the Toolbar for the activity
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            getSearchMovies(query);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getSearchMovies(String query) {

        App.getService().getMovies(query, new CallBack<MovieResponse>() {
            @Override
            public void onSuccess(MovieResponse movieResponse) {
                mAdapter = new DataAdapter(movieResponse.getMovies(), LAYOUT_TYPE_LINEAR);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onError(WaspError error) {
                showToast(error.toString());
            }
        });
    }
}

