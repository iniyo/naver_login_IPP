package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class SignupActivity extends AppCompatActivity {
    LinearLayout chooseMaleLinearLayout, userMaleAndForeignOrDomestic;
    Spinner mobileCarrierSpinner, countryNumberSpinner;
    CheckBox signUPRealUsernameIDCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // 컨트롤 연결
        chooseMaleLinearLayout = (LinearLayout) findViewById(R.id.chooseMaleLinearLayout);
        userMaleAndForeignOrDomestic = (LinearLayout) findViewById(R.id.userMaleAndForeignOrDomestic);
        mobileCarrierSpinner = (Spinner) findViewById(R.id.mobileCarrierSpinner);
        countryNumberSpinner = (Spinner) findViewById(R.id.countryNumberSpinner);
        // checkBox 클릭 리스너
        signUPRealUsernameIDCheckBox = findViewById(R.id.signUPRealUsernameIDCheckBox);
        signUPRealUsernameIDCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedBox(signUPRealUsernameIDCheckBox.isChecked());
            }
        });

    }

    // checkBox의 상태에 따라 보여지는 뷰와 안 보이는 뷰 설정 함수
    private void checkedBox(boolean a) {
        if (a) {
            mobileCarrierSpinner.setVisibility(View.VISIBLE);
            userMaleAndForeignOrDomestic.setVisibility(View.VISIBLE);
            //VISIBLE = 해당 뷰 보여줌, INVISIBLE = 뷰는 안 보이지만 공간은 존재, GONE = 공간도 사라짐
            chooseMaleLinearLayout.setVisibility(View.GONE); // 공간채로 숨김
            countryNumberSpinner.setVisibility(View.GONE);
        } else {
            mobileCarrierSpinner.setVisibility(View.GONE);
            userMaleAndForeignOrDomestic.setVisibility(View.GONE);
            chooseMaleLinearLayout.setVisibility(View.VISIBLE); // 보여줌
            countryNumberSpinner.setVisibility(View.VISIBLE);
        }
    }
}