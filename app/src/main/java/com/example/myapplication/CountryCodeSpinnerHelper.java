package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class CountryCodeSpinnerHelper {

    // 현재 컨텍스트(이 함수를 사용하는 액티비티 혹은 다른), 해당 context에서 사용하는 spinner
    public static void setupCountryCodeSpinner(Context context, Spinner spinner) {
        // 국가 코드와 국가 이름을 함께 구성하여 Set에 추가 (중복 방지, 입력 순서 유지)
        Set<CountryItem> countryItems = new LinkedHashSet<>(); // 그냥 HashSet은 순서가 유지되지 않음. LinkedHashSet을 사용하여 순서 유지
        // context = 실행환경에 대한 객체, 여기선 해당 액티비티
        Resources resources = context.getResources();
        // 안드로이드 설정 언어, 국제 표준 국가명 리스트를 가져와서 문자열 배열에 저장
        String[] countryCodes = Locale.getISOCountries();

        // 문자열 배열에 가져온 값으로 locale에서 해당 나라를 찾음.
        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            // 화면에 보여질 국가 이름을 한국어로 변경
            String displayName = locale.getDisplayCountry(Locale.KOREAN);
            // 지역 이름에 대한 code를 가져옴, getInstance()로 앱이 시작될 때 한번만 메모리 할당.
            int phoneCode = PhoneNumberUtil.getInstance().getCountryCodeForRegion(countryCode);
            // 위에서 생성한 CountryItems에 각국 이름 "+" 국가 번호, 국가 코드 (ex ko_KR)
            countryItems.add(new CountryItem(displayName, "+" + phoneCode, countryCode));
        }

        // 어댑터 설정
        // 사용하는 컨텍스트의 spinner item을 설정, ArrayAdapter 초기화 시 3가지 항목 필요.
        // 1) Context, 2) 배열의 각 항목을 어떻게 표시할 지 지정하는 레이아웃 3) 배열
        ArrayAdapter<CountryItem> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, countryItems.toArray(new CountryItem[0]));
        // dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 부착
        spinner.setAdapter(adapter);

        // 스피너 초기 선택을 대한민국으로 설정
        int koreaIndex = findIndexOfCountry(countryItems, "대한민국");
        if (koreaIndex >= 0) {
            spinner.setSelection(koreaIndex);
        }

        // 스피너에서 아이템 선택 이벤트 리스너 추가
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // 아이템이 선택될 때마다 대한민국이 가장 위에 오도록 아이템 위치를 변경
                if (position > 0) {
                    CountryItem selectedItem = (CountryItem) spinner.getSelectedItem();
                    countryItems.remove(selectedItem);
                    countryItems.add(selectedItem);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // 아무것도 선택되지 않았을 때의 처리
            }
        });
    }

    private static int findIndexOfCountry(Set<CountryItem> countryItems, String countryName) {
        int index = 0;
        for (CountryItem item : countryItems) {
            if (item.getDisplayName().equals(countryName)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    // CountryItem 클래스 정의
    public static class CountryItem {
        private String displayName;
        private String countryCode;
        private String countryCodeAlpha2;

        public CountryItem(String displayName, String countryCode, String countryCodeAlpha2) {
            this.displayName = displayName;
            this.countryCode = countryCode;
            this.countryCodeAlpha2 = countryCodeAlpha2;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public String getCountryCodeAlpha2() {
            return countryCodeAlpha2;
        }

        @Override
        public String toString() {
            return displayName + " " + countryCode;
        }
    }
}
