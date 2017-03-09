package com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.common.fragments.MovieFragment;
import com.inomera.kasap.androidrottentomatoesapp.common.fragments.ReviewFragment;
import com.inomera.kasap.androidrottentomatoesapp.network.models.Movie;

/**
 * Created by Menaf on 02.07.2015
 */
public class MovieActivity extends BaseActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        // Creating The Toolbar and setting it as the Toolbar for the activity
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            MovieFragment MovieFrag = new MovieFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.frame_container, MovieFrag);
            ft.commit();
        } else {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Movie myMovie = this.getIntent().getParcelableExtra("Movie");

        //noinspection SimplifiableIfStatement
        if (id == R.id.share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, myMovie.getTitle());
            sendIntent.putExtra(Intent.EXTRA_TEXT, myMovie.getLinks().getAlternate());
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
        if (id == R.id.imdb) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Uri.parse("http://www.imdb.com/title/tt" + myMovie.getAlternateIds().getImdb()) + "/?ref_=inth_ov_tt"));
            startActivity(browserIntent);
        }

        if (id == R.id.review) {
            ReviewFragment ReviewFrag = new ReviewFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
//            ft.replace(R.id.frame_container, ReviewFrag);
            ft.commit();
        }

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
