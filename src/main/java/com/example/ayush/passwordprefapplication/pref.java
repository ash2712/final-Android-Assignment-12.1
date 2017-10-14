package com.example.ayush.passwordprefapplication;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ayush on 10/14/2017.
 */

public class pref extends PreferenceActivity {
    public static int prefs = R.xml.preference_screen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //replaces fragment with the Preference Fragment given below
        getFragmentManager().beginTransaction().replace(android.R.id.content,new PF()).commit();
    }

    public static class PF extends PreferenceFragment {

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //adding preference from resource
            addPreferencesFromResource(pref.prefs);
        }
    }
}
