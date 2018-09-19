package dotcom.com.sam.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hp YOYO 22-2-2017
 */
public class ESPreferences {

    private static final ESPreferences mShared = new ESPreferences();
    public static final String MyPREFERENCES = "Prefs";
    public static final String DEFAULT = "default";
    public static final int DEFAULT_INT = 0;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public ESPreferences() {

    }

    public static ESPreferences SSP() {
        return mShared;
    }

    public void init(Context appContext) {
        if (mShared != null) {
            sharedPreferences = appContext.getSharedPreferences(MyPREFERENCES, 0);
            editor = sharedPreferences.edit();
        }
    }


    public void putString(String key, String value) {
        editor.putString(key, value);
        commit();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, DEFAULT);
    }

    public void putLong(String key, Long value) {
        editor.putLong(key, value);
        commit();
    }


    public Long getLong(String key) {
        return sharedPreferences.getLong(key, DEFAULT_INT);
    }


    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        commit();
    }

    public boolean getBoolean(String key, boolean value) {
        return sharedPreferences.getBoolean(key, value);
    }

    public void commit() {
        editor.commit();
    }


    public void clearPrefs(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    public void clearAllPrefs() {
        sharedPreferences.edit().clear().apply();
    }
}
