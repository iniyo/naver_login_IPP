package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // textView에 인텐트 이동 효과
        TextView userSignUP = findViewById(R.id.userSignUP);
        userSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                //응답을 받을 경우는 startActivityForResult를 사용한다.
                //아니면 그냥 StartActivity(intent)라 하면된다.
                //즉 둘다 액티비티를 화면에 띄우고 인텐트를 전달해주는 역할
                startActivity(intent);
            }
        });
    }
}