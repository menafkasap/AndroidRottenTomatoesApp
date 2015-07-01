package com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp;

/**
 * Created by Menaf on 17.06.2015
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inomera.kasap.androidrottentomatoesapp.R;
import com.inomera.kasap.androidrottentomatoesapp.network.Movie;
import com.orhanobut.wasp.Wasp;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Movie> mDataset;
    private String mLayout;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;
        public TextView movieTitle;
        public TextView movieYear;
        public ImageView icon;

        public ViewHolder(View v) {
            super(v);
            view = v;
            movieTitle = (TextView) v.findViewById(R.id.firstLine);
            movieYear = (TextView) v.findViewById(R.id.secondLine);
            icon = (ImageView) v.findViewById(R.id.icon);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Movie> myDataset, String layout) {
        mDataset = myDataset;
        mLayout = layout;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        if (mLayout.equals("linear")) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_linear, parent, false);
            return new ViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid, parent, false);
            return new ViewHolder(v);
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.movieTitle.setText(mDataset.get(position).getTitle());
        holder.movieYear.setText(mDataset.get(position).getSynopsis());
        Wasp.Image.from(mDataset.get(position).getPosters().getOriginal()).to(holder.icon).load();
        final int pos = position;
        holder.view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Don't Press...", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}