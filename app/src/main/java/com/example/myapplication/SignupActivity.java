package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SignupActivity extends AppCompatActivity {
    LinearLayout chooseMobileCarrierLayout;
    Spinner countryNumberSpinner;
    CheckBox signUPRealUsernameIDCheckBox, expantionCheckBox, certificationTermsandConditionsCheckBox, mobileCarrierCheckBox1, mobileCarrierCheckBox2;
    CheckBox certificatiion_CheckBox1, certificatiion_CheckBox2, certificatiion_CheckBox3, certificatiion_CheckBox4, certificatiion_CheckBox5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // 컨트롤 연결
        certificatiion_CheckBox1 = (CheckBox) findViewById(R.id.certificatiion_CheckBox1);
        certificatiion_CheckBox2 = (CheckBox) findViewById(R.id.certificatiion_CheckBox2);
        certificatiion_CheckBox3 = (CheckBox) findViewById(R.id.certificatiion_CheckBox3);
        certificatiion_CheckBox4 = (CheckBox) findViewById(R.id.certificatiion_CheckBox4);
        certificatiion_CheckBox5 = (CheckBox) findViewById(R.id.certificatiion_CheckBox5);
        // 통신사 선택 클릭 리스너
        findViewById(R.id.mobile_carrier_TextView1).setOnClickListener(v -> mobile_carrier_TextView_clicked(findViewById(R.id.mobile_carrier_TextView1)));
        findViewById(R.id.mobile_carrier_TextView2).setOnClickListener(v -> mobile_carrier_TextView_clicked(findViewById(R.id.mobile_carrier_TextView2)));
        findViewById(R.id.mobile_carrier_TextView3).setOnClickListener(v -> mobile_carrier_TextView_clicked(findViewById(R.id.mobile_carrier_TextView3)));
        findViewById(R.id.mobile_carrier_TextView4).setOnClickListener(v -> mobile_carrier_TextView_clicked(findViewById(R.id.mobile_carrier_TextView4)));
        findViewById(R.id.mobile_carrier_TextView5).setOnClickListener(v -> mobile_carrier_TextView_clicked(findViewById(R.id.mobile_carrier_TextView5)));
        findViewById(R.id.mobile_carrier_TextView6).setOnClickListener(v -> mobile_carrier_TextView_clicked(findViewById(R.id.mobile_carrier_TextView6)));
        // 실명 인증된 아이디로 가입 checkBox 클릭 리스너
        findViewById(R.id.signUPRealUsernameIDCheckBox).setOnClickListener(v -> signUPRealUsernameIDCheckBoxChecked(signUPRealUsernameIDCheckBox.isChecked()));
        // 인증약관 전체 동의 checkBox 클릭 리스너 x2
        findViewById(R.id.expantionCheckBox).setOnClickListener(v -> expantionCheckBoxChecked(expantionCheckBox.isChecked()));
        findViewById(R.id.certificationTermsandConditionsCheckBox).setOnClickListener(v -> certificationTermsandConditionsCheckBoxChecked(certificationTermsandConditionsCheckBox.isChecked()));
        // mobileCarrierCheckBox 클릭 리스너
        findViewById(R.id.mobileCarrierCheckBox1).setOnClickListener(v -> MobileCarrierCheckBoxClick());
        findViewById(R.id.mobileCarrierCheckBox2).setOnClickListener(v -> MobileCarrierCheckBoxClick());
        // 화면 전환
        findViewById(R.id.signupNaverLogoImage).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
        findViewById(R.id.AuthenticationRequestButton).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), LoginActivity.class)));
        // 국가 번호 선택 Helpher Spinner
        CountryCodeSpinnerHelper.setupCountryCodeSpinner(this, countryNumberSpinner);
    }

    // checkBox의 상태에 따라 보여지는 뷰와 안 보이는 뷰 설정 함수
    private void signUPRealUsernameIDCheckBoxChecked(boolean a) {
        if (a) {
            findViewById(R.id.userMaleAndForeignOrDomestic).setVisibility(View.VISIBLE); // 외국인 내국인 라디오 그룹
            findViewById(R.id.mobile_carrier_popup_Layout).setVisibility(View.VISIBLE); // 통신사 선택 팝업
            findViewById(R.id.certificationLayout).setVisibility(View.VISIBLE); // 인증약관 전체 동의
            //VISIBLE = 해당 뷰 보여줌, INVISIBLE = 뷰는 안 보이지만 공간은 존재, GONE = 공간도 사라짐
            findViewById(R.id.chooseMaleLinearLayout).setVisibility(View.GONE); // 성별 선택, 남자, 여자, 선택안함
            findViewById(R.id.countryNumberSpinner).setVisibility(View.GONE); // 국가 번호 스피너
            findViewById(R.id.contryNumberSpinnerLayout).setVisibility(View.GONE);
        } else {
            findViewById(R.id.mobile_carrier_popup_Layout).setVisibility(View.GONE); // 통신사 선택 팝업
            findViewById(R.id.userMaleAndForeignOrDomestic).setVisibility(View.GONE); // 외국인 내국인 라디오 그룹
            findViewById(R.id.certificationLayout).setVisibility(View.GONE); // 인증약관 전체 동의
            findViewById(R.id.chooseMaleLinearLayout).setVisibility(View.VISIBLE); // 성별 선택, 남자, 여자, 선택안함
            findViewById(R.id.countryNumberSpinner).setVisibility(View.VISIBLE); // 국가 번호 스피너
            findViewById(R.id.contryNumberSpinnerLayout).setVisibility(View.VISIBLE);
        }
    }

    private void mobile_carrier_TextView_clicked(TextView textView) {
        mobileCarrierCheckBox1.setText(textView.getText());
        findViewById(R.id.chooseMobileCarrierLayout).setVisibility(View.GONE);
        mobileCarrierCheckBox1.setChecked(false);
        mobileCarrierCheckBox2.setChecked(false);
    }
    private void expantionCheckBoxChecked(boolean a) {
        if (a) {
            findViewById(R.id.expansion_certification_touch_Layout).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.expansion_certification_touch_Layout).setVisibility(View.GONE);
        }
    }
    private void certificationTermsandConditionsCheckBoxChecked(boolean a) {
        if (a) {
            certificatiion_CheckBox1.setChecked(true);
            certificatiion_CheckBox2.setChecked(true);
            certificatiion_CheckBox3.setChecked(true);
            certificatiion_CheckBox4.setChecked(true);
            certificatiion_CheckBox5.setChecked(true);
        } else {
            certificatiion_CheckBox1.setChecked(false);
            certificatiion_CheckBox2.setChecked(false);
            certificatiion_CheckBox3.setChecked(false);
            certificatiion_CheckBox4.setChecked(false);
            certificatiion_CheckBox5.setChecked(false);
        }
    }
    private void MobileCarrierCheckBoxClick() {
        if (mobileCarrierCheckBox1.isChecked() || mobileCarrierCheckBox2.isChecked()) {
            chooseMobileCarrierLayout.setVisibility(View.VISIBLE);
            mobileCarrierCheckBox1.setChecked(true);
            mobileCarrierCheckBox2.setChecked(true);
        } else {
            chooseMobileCarrierLayout.setVisibility(View.GONE);
        }
    }
}