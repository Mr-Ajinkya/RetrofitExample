package Prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lenovo on 1/3/2018.
 */

public class Prefs {

    private static final String PREFS_SAVE_USER = "save_user_id";
    private static final String KEY_USER_ID = "user_id";

    public static void saveUserId(Context context, String userId) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_SAVE_USER,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_ID,userId).apply();
    }

    public static String getUserId(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_SAVE_USER,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_ID,null);
    }

}
