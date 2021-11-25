package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SignUp extends AppCompatActivity {
    Button signup;
    TextView tv,title;
    FrameLayout img_back;
    EditText phone,user,pass,confpass;
    LinearLayout footer;
    float v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        signup = (Button) findViewById(R.id.btn_sign_up);
        tv = (TextView) findViewById(R.id.tv_login) ;
        img_back = (FrameLayout) findViewById(R.id.img_back);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, dashboard2.class);
                startActivity(intent);
            }
        });
        user = findViewById(R.id.edt_user);
        pass = findViewById(R.id.edt_pass);
        title = findViewById(R.id.title_signup);
        phone = findViewById(R.id.edt_phone);
        confpass = findViewById(R.id.edt_passcomfirm);
        footer = findViewById(R.id.footer);

        animateView(phone, 200);
        animateView(user, 400);
        animateView(pass, 600);
        animateView(confpass, 800);
        animateView(signup, 1000);
        animateView(signup, 1200);
        animateView(footer, 1400);

        title.setAlpha(v);
        title.animate().alpha(1).setDuration(800).setStartDelay(200).start();

    }
    private void animateView (View view, int delay) {
        view.setTranslationX(200);
        view.setAlpha(v);
        view.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(delay).start();
    }

}