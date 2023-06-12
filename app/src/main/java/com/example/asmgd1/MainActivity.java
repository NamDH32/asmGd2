package com.example.asmgd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), dangnhap.class);
                startActivity(intent);
            }
        },4000);
        ImageView img_logo = findViewById(R.id.img_logo);
        Animation animi = AnimationUtils.loadAnimation(this, R.anim.img_txt);
        img_logo.startAnimation(animi);

        TextView txt_bn = findViewById(R.id.txt_bnLogo);
        Animation animin = AnimationUtils.loadAnimation(this,  R.anim.img_txt);
        txt_bn.startAnimation(animin);

        ImageView img_lgog2 = findViewById(R.id.img_logo2);
        Animation amni = AnimationUtils.loadAnimation(this , R.anim.img_txt);
        img_lgog2.startAnimation(amni);
    }
}