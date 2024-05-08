package com.example.bowling;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private static final String LOG_TAG=RegisterActivity.class.getName();
    private static final String PREF_KEY= MainActivity.class.getPackage().toString();
    private SharedPreferences preferences;
    EditText fullnameET;
    EditText usernameET;
    EditText phonenumberET;
    EditText birthdateET;
    EditText emailET;
    EditText passwordET;
    EditText passwordagainET;
    CheckBox acceptCB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        Bundle bundle = getIntent().getExtras();
        int secret_key= bundle.getInt("SECRET_KEY");
        if(secret_key!=99){
            finish();
        }
        emailET=findViewById(R.id.email_edittext);
        passwordET=findViewById(R.id.password_edittext);
        passwordagainET=findViewById(R.id.confirm_password_edittext);
        fullnameET=findViewById(R.id.fullname_edittext);
        usernameET=findViewById(R.id.username_edittext);
        phonenumberET=findViewById(R.id.phone_edittext);
        birthdateET=findViewById(R.id.birthdate_edittext);
        acceptCB=findViewById(R.id.accept_checkbox);

        preferences=getSharedPreferences(PREF_KEY,MODE_PRIVATE);
        String email=preferences.getString("email","");



        emailET.setText(email);

    }

    public void register(View view) {


        String email=emailET.getText().toString();
        String password=passwordET.getText().toString();
        String passwordagain=passwordagainET.getText().toString();
        String fullname=fullnameET.getText().toString();
        String username=usernameET.getText().toString();
        String phone=phonenumberET.getText().toString();
        String birthdate=birthdateET.getText().toString();
        Boolean accept=acceptCB.isChecked();

        if(!password.equals(passwordagain)){
            Log.e(LOG_TAG,"Nem egyeznek a jelszavak!");
        }
        if(!accept){
            Log.e(LOG_TAG,"Fogadd el a feltételeket!");
        }

        Log.i(LOG_TAG,"Regisztrált: "+fullname+" jelszó: "+password);


    }
}