package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;



public class Login extends AppCompatActivity {
    Button login;
    TextView tv,user,pass,title;
    FrameLayout img_back;
    LinearLayout footer;
    float v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        login = (Button) findViewById(R.id.btn_login);
        tv = (TextView) findViewById(R.id.tv_signup) ;
        img_back = (FrameLayout) findViewById(R.id.img_back);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, dashboard2.class);
                startActivity(intent);
            }
        });
        user = findViewById(R.id.edt_user);
        pass = findViewById(R.id.edt_pass);
        title = findViewById(R.id.title_login);
        footer = findViewById(R.id.footer);


        animateView(user, 300);
        animateView(pass, 500);
        animateView(login, 700);
        animateView(footer, 900);

        title.setAlpha(v);
        title.animate().alpha(1).setDuration(800).setStartDelay(300).start();

    }
    private void animateView (View view, int delay) {
        view.setTranslationX(200);
        view.setAlpha(v);
        view.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(delay).start();
    }
}