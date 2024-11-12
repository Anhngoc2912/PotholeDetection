package com.example.potholedectection.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.potholedectection.Activity.Account_Security_Activity;
import com.example.potholedectection.Activity.Login_Activity;
import com.example.potholedectection.R;

import java.util.Locale;

public class Setting_Fragment extends Fragment {

    private View view;
    private TextView infor, language, Notification, support, support2;
    private Button btn_Logout;
    private Spinner spinner;
    public static final String[] Language = {"Languge", "English", "Tiếng Việt"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_fragment_setting, container, false);

        infor = view.findViewById(R.id.infor);
        btn_Logout = view.findViewById(R.id.btn_Logout);
        spinner = view.findViewById(R.id.spinner);

        infor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Account_Security_Activity.class);
                startActivity(intent);
            }
        });

        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Login_Activity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Language);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                String selected = adapterView.getItemAtPosition(position).toString();
                if (selected.equals("English")) {

                    setLocal("en");
                    recreateApp();
                } else if (selected.equals("Tiếng Việt")) {

                    setLocal("vie");
                    recreateApp();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return view;
    }

    private void setLocal(String langCode) {
        saveLanguage(langCode);//lưu ngôn ngữ
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources resources = getActivity().getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

    // phương thức này để refresh activity
    private void recreateApp() {
        Intent intent = getActivity().getIntent();
        getActivity().finish();
        startActivity(intent);
    }

    //Lưu ngôn ngữ đã chọn vào SharedPreferences để giữ nguyên sau khi đóng ứng dụng
    private void saveLanguage(String lang) {
        SharedPreferences prefs = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Language", lang);
        editor.apply();
    }
}
