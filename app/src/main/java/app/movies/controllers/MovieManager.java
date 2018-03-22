package app.movies.controllers;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONObject;

import java.util.List;

import app.movies.Utilities.Constants;
import app.movies.models.Movie;

/**
 * Created by Rishi on 3/21/2018.
 */

public class MovieManager implements Constants.MOVIE {

    private static final String TAG = MovieManager.class.getSimpleName();
    private Context mContext;
    private MovieListInterface mMovieListInterface;

    public MovieManager(Context context,MovieListInterface movieListInterface){
        mContext = context;
        mMovieListInterface = movieListInterface;
    }


    public void fetchMovieList(int tab){
        String apiUrl = tab == 0 ? Constants.BASE_URL+Constants.NOW_PLAYING : Constants.BASE_URL+Constants.UPCOMING;

        AndroidNetworking.get(apiUrl)
                .addQueryParameter(PAGE, "1")
                .addQueryParameter(Constants.APIKEY, Constants.APIKEY_VALUE)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mMovieListInterface.onMoviesListFetced(new JSONParser().parseMovieList(response));
                    }

                    @Override
                    public void onError(ANError anError) {
                        mMovieListInterface.onMoviesFetchFailed(anError.getErrorDetail());
                    }
                });
    }



}
