package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class SignupActivity extends AppCompatActivity {
    LinearLayout chooseMobileCarrierLayout, chooseMaleLinearLayout, userMaleAndForeignOrDomestic, mobile_carrier_popup_Layout, certificationLayout, contryNumberSpinnerLayout, expansion_certification_touch_Layout;
    Spinner countryNumberSpinner;
    CheckBox signUPRealUsernameIDCheckBox, expantionCheckBox, certificationTermsandConditionsCheckBox, mobileCarrierCheckBox1, mobileCarrierCheckBox2;
    ImageView signupNaverLogoImage;
    CheckBox certificatiion_CheckBox1, certificatiion_CheckBox2, certificatiion_CheckBox3, certificatiion_CheckBox4, certificatiion_CheckBox5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // 컨트롤 연결
        chooseMaleLinearLayout = (LinearLayout) findViewById(R.id.chooseMaleLinearLayout);
        userMaleAndForeignOrDomestic = (LinearLayout) findViewById(R.id.userMaleAndForeignOrDomestic);
        contryNumberSpinnerLayout = (LinearLayout) findViewById(R.id.contryNumberSpinnerLayout);
        mobile_carrier_popup_Layout = (LinearLayout) findViewById(R.id.mobile_carrier_popup_Layout);
        certificationLayout = (LinearLayout) findViewById(R.id.certificationLayout);
        expansion_certification_touch_Layout = (LinearLayout) findViewById(R.id.expansion_certification_touch_Layout);
        chooseMobileCarrierLayout = (LinearLayout) findViewById(R.id.chooseMobileCarrierLayout);
        countryNumberSpinner = (Spinner) findViewById(R.id.countryNumberSpinner);
        expantionCheckBox = (CheckBox) findViewById(R.id.expantionCheckBox);
        signupNaverLogoImage = (ImageView) findViewById(R.id.signupNaverLogoImage);
        certificationTermsandConditionsCheckBox = (CheckBox) findViewById(R.id.certificationTermsandConditionsCheckBox);
        certificatiion_CheckBox1 = (CheckBox) findViewById(R.id.certificatiion_CheckBox1);
        certificatiion_CheckBox2 = (CheckBox) findViewById(R.id.certificatiion_CheckBox2);
        certificatiion_CheckBox3 = (CheckBox) findViewById(R.id.certificatiion_CheckBox3);
        certificatiion_CheckBox4 = (CheckBox) findViewById(R.id.certificatiion_CheckBox4);
        certificatiion_CheckBox5 = (CheckBox) findViewById(R.id.certificatiion_CheckBox5);
        mobileCarrierCheckBox1 = (CheckBox) findViewById(R.id.mobileCarrierCheckBox1);
        mobileCarrierCheckBox2 = (CheckBox) findViewById(R.id.mobileCarrierCheckBox2);
        // 실명 인증된 아이디로 가입 checkBox 클릭 리스너
        signUPRealUsernameIDCheckBox = findViewById(R.id.signUPRealUsernameIDCheckBox);
        signUPRealUsernameIDCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUPRealUsernameIDCheckBoxChecked(signUPRealUsernameIDCheckBox.isChecked());
            }
        });
        signupNaverLogoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        // 인증약관 전체 동의 checkBox 클릭 리스너
        expantionCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expantionCheckBoxChecked(expantionCheckBox.isChecked());
            }
        });

        certificationTermsandConditionsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                certificationTermsandConditionsCheckBoxChecked(certificationTermsandConditionsCheckBox.isChecked());
            }
        });

        // mobileCarrierCheckBox 클릭 리스너
        mobileCarrierCheckBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MobileCarrierCheckBoxClick();
            }
        });

        mobileCarrierCheckBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MobileCarrierCheckBoxClick();
            }
        });

        // 국가 번호 선택 Helpher Spinner
        CountryCodeSpinnerHelper.setupCountryCodeSpinner(this, countryNumberSpinner);


    }

    // checkBox의 상태에 따라 보여지는 뷰와 안 보이는 뷰 설정 함수
    private void signUPRealUsernameIDCheckBoxChecked(boolean a) {
        if (a) {
            userMaleAndForeignOrDomestic.setVisibility(View.VISIBLE); // 외국인 내국인 라디오 그룹
            mobile_carrier_popup_Layout.setVisibility(View.VISIBLE); // 통신사 선택 팝업
            certificationLayout.setVisibility(View.VISIBLE); // 인증약관 전체 동의
            //VISIBLE = 해당 뷰 보여줌, INVISIBLE = 뷰는 안 보이지만 공간은 존재, GONE = 공간도 사라짐
            chooseMaleLinearLayout.setVisibility(View.GONE); // 성별 선택, 남자, 여자, 선택안함
            countryNumberSpinner.setVisibility(View.GONE); // 국가 번호 스피너
            contryNumberSpinnerLayout.setVisibility(View.GONE);
        } else {
            mobile_carrier_popup_Layout.setVisibility(View.GONE); // 통신사 선택 팝업
            userMaleAndForeignOrDomestic.setVisibility(View.GONE); // 외국인 내국인 라디오 그룹
            certificationLayout.setVisibility(View.GONE); // 인증약관 전체 동의
            chooseMaleLinearLayout.setVisibility(View.VISIBLE); // 성별 선택, 남자, 여자, 선택안함
            countryNumberSpinner.setVisibility(View.VISIBLE); // 국가 번호 스피너
            contryNumberSpinnerLayout.setVisibility(View.VISIBLE);
        }
    }

    private void expantionCheckBoxChecked(boolean a) {
        if(a){
            expansion_certification_touch_Layout.setVisibility(View.VISIBLE);
        }else {
            expansion_certification_touch_Layout.setVisibility(View.GONE);
        }
    }

    private void certificationTermsandConditionsCheckBoxChecked(boolean a){
        if(a){
            certificatiion_CheckBox1.setChecked(true);
            certificatiion_CheckBox2.setChecked(true);
            certificatiion_CheckBox3.setChecked(true);
            certificatiion_CheckBox4.setChecked(true);
            certificatiion_CheckBox5.setChecked(true);
        }else{
            certificatiion_CheckBox1.setChecked(false);
            certificatiion_CheckBox2.setChecked(false);
            certificatiion_CheckBox3.setChecked(false);
            certificatiion_CheckBox4.setChecked(false);
            certificatiion_CheckBox5.setChecked(false);
        }
    }
    private void checkboxCheckedVerification(boolean a1, boolean a2, boolean a3, boolean a4, boolean a5){

    }

    private void MobileCarrierCheckBoxClick() {
        if (mobileCarrierCheckBox1.isChecked() || mobileCarrierCheckBox2.isChecked()) {
            chooseMobileCarrierLayout.setVisibility(View.VISIBLE);
        } else {
            chooseMobileCarrierLayout.setVisibility(View.GONE);
        }
    }
}