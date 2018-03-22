package app.movies.Utilities;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Akshay on 3/21/2018.
 */

public class Utility {
    public static void showSnackBar(String message,View view){
        Snackbar snackbar1 = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        snackbar1.show();
    }
}
