package app.movies.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.movies.Utilities.Constants;
import app.movies.models.Movie;

/**
 * Created by Rishi on 3/21/2018.
 */

public class JSONParser implements Constants.MOVIE {

    public List<Movie> parseMovieList(JSONObject response) {
        List<Movie> movies = new ArrayList<Movie>();

        try {
            JSONArray jsonArray = response.getJSONArray(RESULTS);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Movie item = new Movie();
                    item.title = jsonObject.isNull(TITLE)?"":jsonObject.getString(TITLE);
                    item.popularity = jsonObject.isNull(POPULARITY)?"":(((int)Float.parseFloat(jsonObject.getString(POPULARITY)))/10)+"%";
                    item.backdrop_path = jsonObject.isNull(BACKDROP_PATH)?"":jsonObject.getString(BACKDROP_PATH);
                    movies.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
