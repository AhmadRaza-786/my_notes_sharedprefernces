package com.example.mynotes;

import android.content.Context;
import android.content.SharedPreferences;

public class MyNote {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String ARCHIVE_NAME = "note.preferences";
    private final String KEY_NAME = "name";


    public MyNote(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(ARCHIVE_NAME, 0);
        editor = preferences.edit();
    }

    public void saveNotes(String notation) {
        editor.putString(KEY_NAME, notation);
        editor.commit();
    }

    public String receiveNotes() {
        return preferences.getString(KEY_NAME, "");
    }
}
