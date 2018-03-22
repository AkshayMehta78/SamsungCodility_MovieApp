package app.movies.controllers;

import java.util.List;

import app.movies.models.Movie;

/**
 * Created by Akshay on 3/21/2018.
 */

public interface MovieListInterface {

    void onMoviesListFetced(List<Movie> movieList);
    void onMoviesFetchFailed(String message);
}
