package com.my.heakthapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
   // PrefManager prefManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        imageView = (ImageView) findViewById(R.id.img);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


       // prefManager=new PrefManager(getApplicationContext());
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            /*    if (prefManager.isLoggedIn()) {
                    Intent intent = new Intent(SplashScreen.this, LanguageMainActivity.class);
                    startActivity(intent);
                    finish();
                }

                else
                {
                    Intent intent = new Intent(SplashScreen.this, Login_Activity.class);
                    startActivity(intent);
                    finish();
                }*/
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
