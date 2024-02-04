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

    public static void setupCountryCodeSpinner(Context context, Spinner spinner) {
        // 국가 코드와 국가 이름을 함께 구성하여 Set에 추가 (중복 방지, 입력 순서 유지)
        Set<CountryItem> countryItems = new LinkedHashSet<>();

        Resources resources = context.getResources();
        String[] countryCodes = Locale.getISOCountries();

        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            String displayName = locale.getDisplayCountry(Locale.KOREAN);
            int phoneCode = PhoneNumberUtil.getInstance().getCountryCodeForRegion(countryCode);
            countryItems.add(new CountryItem(displayName, "+" + phoneCode, countryCode));
        }

        // 어댑터 설정
        ArrayAdapter<CountryItem> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, countryItems.toArray(new CountryItem[0]));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
