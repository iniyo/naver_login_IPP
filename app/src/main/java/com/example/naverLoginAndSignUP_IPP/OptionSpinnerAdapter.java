package com.example.naverLoginAndSignUP_IPP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OptionSpinnerAdapter extends BaseAdapter {
    private Context context;
    private String[] countryArray;

    public OptionSpinnerAdapter(Context context) {
        this.context = context;
        this.countryArray = context.getResources().getStringArray(R.array.country_array); // country 배열 가져옴.
    }

    @Override
    public int getCount() {
        return countryArray.length;
    }

    @Override
    public Object getItem(int position) {
        return countryArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 뷰를 재사용하거나 새로 생성
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        // 텍스트 설정
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(countryArray[position]);

        return convertView;
    }
}
