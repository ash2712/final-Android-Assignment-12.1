package com.example.ayush.passwordprefapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final TextView tv_1 =(TextView)findViewById(R.id.textView);
        final TextView tv_2 =(TextView)findViewById(R.id.textView2);
        final TextView tv_3 =(TextView)findViewById(R.id.textView3);
        //initialization
        Button bt_1 = (Button) findViewById(R.id.settings);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, pref.class);
                //opens to the settings page on click of the button
                startActivity(intent);
            }
        });

        Button bt_2 =(Button) findViewById(R.id.displayInfo);
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = sharedPreferences.getString("PREF_EDITTEXT", null);
                boolean isEnabled = sharedPreferences.getBoolean("PREF_CHECKBOX", false);
                String reminderUpdate = sharedPreferences.getString("PREF_LIST", null);
                //gets information from the SharedPreferences
                String finalReminderUpdate = null;
                if(reminderUpdate.equals("1")){
                    finalReminderUpdate = "10 Minutes";
                }
                else if(reminderUpdate.equals("2")){
                    finalReminderUpdate = "One Hour";
                }
                else if(reminderUpdate.equals("3")){
                    finalReminderUpdate = "One Day";
                }
                else{
                    finalReminderUpdate = "One Month";
                }
                //above is because remiderUpdate returns a number and hence find the value that corresponds with that number
                tv_1.setText("Password: "+password);
                tv_2.setText("Lock Screen: " + isEnabled);
                tv_3.setText("Reminder Update: " + finalReminderUpdate);
                //info is displayed
            }
        });

    }
}
