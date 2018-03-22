package app.movies.Utilities;

/**
 * Created by Akshay on 3/21/2018.
 */

public class Constants {

    public final static String BASE_URL = "https://api.themoviedb.org/3/movie";
    public final static String NOW_PLAYING = "/now_playing";
    public final static String APIKEY = "api_key";
    public final static String APIKEY_VALUE = "2907186cad40a594f4849159c1088072";
    public static final String IMAGE_PREFIX = "http://image.tmdb.org/t/p/w300";
    public static final String UPCOMING = "/upcoming";

    public interface MOVIE {
        String PAGE = "page";
        String RESULTS = "results";
        String TITLE = "title";
        String POPULARITY = "popularity";
        String BACKDROP_PATH = "backdrop_path";
    }

}
