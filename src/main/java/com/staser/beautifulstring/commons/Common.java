package com.staser.beautifulstring.commons;


import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * common class with static variables
 */
public class Common {

    public static String THREE_POINTS = "...";
    public static String THREE_POINTS_CHANGE = "staser_just_three_points.";
    public static String THREE_POINTS_CHANGE_BACK = " staser_just_three_points";

    public static void hideKeyboard(Activity activity) {
        InputMethodManager _imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View _view = activity.getCurrentFocus();
        if (_view == null) {
            _view = new View(activity);
        }
        _imm.hideSoftInputFromWindow(_view.getWindowToken(), 0);
    }
}
