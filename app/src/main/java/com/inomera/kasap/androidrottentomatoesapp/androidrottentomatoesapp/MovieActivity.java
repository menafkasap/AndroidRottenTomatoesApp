package com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.network.models.Movie;
import com.orhanobut.wasp.Wasp;

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
        Movie myMovie = getIntent().getParcelableExtra("Movie");
        this.setTitle(myMovie.getTitle());

        Wasp.Image.from("http://" + myMovie.getPosters().getOriginal().replaceAll(".*=/...../","")).to((ImageView) findViewById(R.id.poster)).load();

        TextView rating = (TextView) findViewById(R.id.rating);
        //rating.setText(Integer.toString(myMovie.getRating().getCriticsScore()));
        rating.setText("RATINGS");
        //showToast("");
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
