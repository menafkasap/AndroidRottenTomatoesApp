package com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @author Emmar Kardeslik
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected void showToast(String text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
