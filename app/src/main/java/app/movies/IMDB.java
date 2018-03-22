package app.movies;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by Akshay on 3/21/2018.
 */

public class IMDB extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
