package com.example.ncdc_selftest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.ncdc_selftest.Activities.Result;
import com.example.ncdc_selftest.Activities.Result2;
import com.example.ncdc_selftest.Activities.Result3;
import com.example.ncdc_selftest.Model.Model;
import com.example.ncdc_selftest.R;

import java.util.List;


public class Adapter extends PagerAdapter {


    Button button1;
    Button button2;
    int clickcount1 = 0;
    int clickcount2 = 0;
    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;
    int  [] count = new int [12];

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView question;

        imageView = view.findViewById(R.id.image);
        question = view.findViewById(R.id.question);
        button1 = view.findViewById(R.id.button_yes);
        button2 = view.findViewById(R.id.button_no);


        imageView.setImageResource(models.get(position).getImage());
        question.setText(models.get(position).getQuestion());


//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailActivity.class);
//                intent.putExtra("param", models.get(position).getTitle());
//                context.startActivity(intent);
//                // finish();
//            }
//        });


   button1.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

           if (count[position] <= 0){
               count [position] = 1;
           }
           for (int i=0; i<count.length;i++){
               if (count[i] != 0){
                   if (count[i] == 1){
                       clickcount1 += 1;
                   }
               }else {
                   clickcount1 = 0;
                   clickcount2 = 0;
               }
           } if (clickcount1 >= 9) {
               Intent intent = new Intent(context, Result.class);
               context.startActivity(intent);
           }else if ((clickcount1 >4) && (clickcount1 <9)){
               Intent intent = new Intent (context, Result2.class);
               context.startActivity(intent);
           }
       }
   });

   button2.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           if (count[position] <= 0){
               count [position] = 2;
           }
           for (int i=0; i<count.length;i++){
               if (count[i] != 0){
                   if (count[i] == 2){
                       clickcount2 += 1;
                   }
               }else {
                   clickcount1 = 0;
                   clickcount2 = 0;
               }
           } if (clickcount2 >= 9) {
               Intent intent = new Intent(context, Result3.class);
               context.startActivity(intent);
           }else if ((clickcount2 >4) && (clickcount2 <9)){
               Intent intent = new Intent( context, Result2.class);
               context.startActivity(intent);
           }
       }
   });


        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}