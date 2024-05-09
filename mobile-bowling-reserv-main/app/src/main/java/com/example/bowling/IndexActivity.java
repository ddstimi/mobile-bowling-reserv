package com.example.bowling;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_index);
        Bundle bundle = getIntent().getExtras();
        int secret_key= bundle.getInt("SECRET_KEY");
        if(secret_key!=99){
            finish();
        }
    }

    public void reservPage(View view) {
        Intent intent = new Intent(this, ReservActivity.class);
        intent.putExtra("SECRET_KEY",99);
        intent.setDataAndType(Uri.parse("file://" + "/path/to/your/activity_reserv.xml"), "text/xml");
        startActivity(intent);
    }
}