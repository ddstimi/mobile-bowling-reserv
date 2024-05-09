package com.example.bowling;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bowling.R;
import com.example.bowling.RegisterActivity;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG=MainActivity.class.getName();
    private static final String PREF_KEY=MainActivity.class.getPackage().toString();
    private SharedPreferences preferences;
    private static final int SECRET_KEY=99;
    EditText emailET;
    EditText passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailET=findViewById(R.id.email_edittext);
        passwordET=findViewById(R.id.password_edittext);

        preferences=getSharedPreferences(PREF_KEY,MODE_PRIVATE);
    }

    public void login(View view) {


        String email=emailET.getText().toString();
        String password=passwordET.getText().toString();

        Log.i(LOG_TAG,"Bejelentkezett: "+email+" jelszó: "+password);

        Intent intent = new Intent(this, IndexActivity.class);
        intent.putExtra("SECRET_KEY",99);
        intent.setDataAndType(Uri.parse("file://" + "/path/to/your/activity_index.xml"), "text/xml");
        startActivity(intent);

    }

    public void registerPage(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra("SECRET_KEY",99);
        intent.setDataAndType(Uri.parse("file://" + "/path/to/your/activity_register.xml"), "text/xml");
        startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("email",emailET.getText().toString());
        editor.putString("password",passwordET.getText().toString());
        editor.apply();
    }
}