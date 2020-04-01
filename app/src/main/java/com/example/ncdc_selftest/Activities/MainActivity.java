package com.example.ncdc_selftest.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import com.example.ncdc_selftest.Adapter.Adapter;
import com.example.ncdc_selftest.Model.Model;
import com.example.ncdc_selftest.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        models = new ArrayList<>();
        models.add(new Model(R.drawable.coughing, "Do you have cough?"));
        models.add(new Model(R.drawable.cold, "Do you have a cold?"));
        models.add(new Model(R.drawable.diarrhea, "Are you having Diarrhea?"));
        models.add(new Model(R.drawable.sorethroat, "Are you having sorethroat?"));
        models.add(new Model(R.drawable.bodypain, "Are you having body aches?"));
        models.add(new Model(R.drawable.headache, "Are you having haedache?"));
        models.add(new Model(R.drawable.temperature, "Do you have fever (Temperature 37.8\u2103 and above?)"));
        models.add(new Model(R.drawable.breathing, "Are you having difficulty breathing?"));
        models.add(new Model(R.drawable.fatigue, "Are you experiencing fatigue?"));
        models.add(new Model(R.drawable.traveled, "Have you traveled recently during the past 14 days?"));
        models.add(new Model(R.drawable.travelhistory, "Do you have a history of travelling to an area infected with COVID-19"));
        models.add(new Model(R.drawable.contacts, "Do you have direct contact with COVID-19 PATIENT?"));



        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
                getResources().getColor(R.color.color7),
                getResources().getColor(R.color.color8),
                getResources().getColor(R.color.color9),
                getResources().getColor(R.color.color10),
                getResources().getColor(R.color.color11),
                getResources().getColor(R.color.color12)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });





    }
}