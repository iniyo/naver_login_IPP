package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.view.View;



public class SignupActivity extends AppCompatActivity {
    LinearLayout chooseMaleLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }
    private void checkedBox(){
        // 컨트롤 연결
        chooseMaleLinearLayout = (LinearLayout)findViewById(R.id.chooseMaleLinearLayout);
        //VISIBLE = 해당 뷰 보여줌, INVISIBLE = 뷰는 안 보이지만 공간은 존재, GONE = 공간도 사라짐
        chooseMaleLinearLayout.setVisibility(View.GONE);
    }
}