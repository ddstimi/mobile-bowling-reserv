package com.example.bowling;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
        ImageView logo = findViewById(R.id.logo_image);
        TextView bowling = findViewById(R.id.bowling_text);
        LinearLayout menu = findViewById(R.id.menu_bar);
        CardView intro = findViewById(R.id.intro_card);
        CardView open = findViewById(R.id.open_card);

        // Animáció betöltése
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_page);

        // Animáció hozzáadása a TextView elemekhez
        logo.startAnimation(fadeInAnimation);
        bowling.startAnimation(fadeInAnimation);
        menu.startAnimation(fadeInAnimation);
        intro.startAnimation(fadeInAnimation);
        open.startAnimation(fadeInAnimation);
    }

    public void reservPage(View view) {
        Intent intent = new Intent(this, ReservActivity.class);
        intent.putExtra("SECRET_KEY",99);
        intent.setDataAndType(Uri.parse("file://" + "/path/to/your/activity_reserv.xml"), "text/xml");
        startActivity(intent);
    }

    public void profile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("SECRET_KEY",99);
        intent.setDataAndType(Uri.parse("file://" + "/path/to/your/activity_profile.xml"), "text/xml");
        startActivity(intent);
    }

    public void indexPage(View view) {
    }
}