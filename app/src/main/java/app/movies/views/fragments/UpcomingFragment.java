package app.movies.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.movies.R;
import app.movies.Utilities.Utility;
import app.movies.controllers.MovieListInterface;
import app.movies.controllers.MovieManager;
import app.movies.models.Movie;
import app.movies.views.adapters.MovieListRecyclerViewAdapter;


public class UpcomingFragment extends Fragment implements MovieListInterface{

    private MovieManager mMovieManager;
    private RecyclerView mRecyclerview;

    public UpcomingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reyclerview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerview = view.findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        mMovieManager = new MovieManager(getActivity(),this);
        mMovieManager.fetchMovieList(1);
    }

    @Override
    public void onMoviesListFetced(List<Movie> movieList) {
        MovieListRecyclerViewAdapter movieListRecyclerViewAdapter = new MovieListRecyclerViewAdapter(getActivity(),movieList);
        mRecyclerview.setAdapter(movieListRecyclerViewAdapter);
    }

    @Override
    public void onMoviesFetchFailed(String message) {
        Utility.showSnackBar(message,mRecyclerview);
    }
}