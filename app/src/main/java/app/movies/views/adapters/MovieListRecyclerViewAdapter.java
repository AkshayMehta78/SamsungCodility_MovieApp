package app.movies.views.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.movies.R;
import app.movies.Utilities.Constants;
import app.movies.models.Movie;

/**
 * Created by Akshay
 */

public class MovieListRecyclerViewAdapter extends RecyclerView.Adapter {

    private static final String TAG = MovieListRecyclerViewAdapter.class.getSimpleName();
    Activity mActivity;
    List<Movie> mMovieArrayList;

    public MovieListRecyclerViewAdapter(Activity activity, List<Movie> mMovieArrayList) {
        mActivity = activity;
        this.mMovieArrayList = mMovieArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_movie_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        Movie item = mMovieArrayList.get(position);

        viewHolder.titleTextView.setText(item.title);
        viewHolder.popularityTextView.setText(item.popularity);
        Picasso.get().load(Constants.IMAGE_PREFIX+item.backdrop_path).into(viewHolder.imageView);
    }


    @Override
    public int getItemCount() {
        return mMovieArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titleTextView,popularityTextView;

        public MyViewHolder(View view) {
            super(view);
            imageView  = view.findViewById(R.id.imageView);
            titleTextView  = view.findViewById(R.id.titleTextView);
            popularityTextView  = view.findViewById(R.id.popularityTextView);
        }

    }
}