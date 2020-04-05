package com.example.ncdc_selftest.Activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ncdc_selftest.Model.Complaintmodel;
import com.example.ncdc_selftest.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Complaints extends AppCompatActivity {

    Button button;
    EditText editText1, editText2, editText3, editText4, editText5;
    EditText editText6, editText7, editText8, editText9, editText10, editText11;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;
    CheckBox checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17, checkBox18, checkBox19, checkBox20;
    CheckBox checkBox21, checkBox22, checkBox23, checkBox24, checkBox25, checkBox26, checkBox27, checkBox28, checkBox29, checkBox30;
    CheckBox checkBox31, checkBox32, checkBox33, checkBox34, checkBox35, checkBox36, checkBox37, checkBox38, checkBox39, checkBox40;
    CheckBox checkBox41, checkBox42, checkBox43, checkBox44, checkBox45, checkBox46, checkBox47, checkBox48, checkBox49, checkBox50;
    CheckBox checkBox51, checkBox52, checkBox53, checkBox54, checkBox55, checkBox56, checkBox57, checkBox58, checkBox59, checkBox60;
    CheckBox checkBox61, checkBox62, checkBox63, checkBox64, checkBox65, checkBox66, checkBox67, checkBox68, checkBox69, checkBox70;
    CheckBox checkBox71, checkBox72, checkBox73, checkBox74, checkBox75, checkBox76, checkBox77, checkBox78, checkBox79, checkBox80;
    CheckBox checkBox81, checkBox82, checkBox83, checkBox84, checkBox85, checkBox86, checkBox87, checkBox88, checkBox89, checkBox90;
    CheckBox checkBox91, checkBox92, checkBox93, checkBox94;
    DatabaseReference reference;
    Complaintmodel complaintmodel;
    long maxid=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaints);
        reference = FirebaseDatabase.getInstance().getReference().child("Complaints");
        complaintmodel = new Complaintmodel();
        button = (Button) findViewById(R.id.submit_btn);
        editText1 = (EditText) findViewById(R.id.edittext_name);
        editText2 = (EditText) findViewById(R.id.edittext_address);
        editText3 = (EditText) findViewById(R.id.edittext_date);
        editText4 = (EditText) findViewById(R.id.edittext_age);
        editText5 = (EditText) findViewById(R.id.edittext_history);
        editText6 = (EditText) findViewById(R.id.edittext_medication);
        editText7 = (EditText) findViewById(R.id.edittext_allergies);
        editText8 = (EditText) findViewById(R.id.edittext_symptoms);
        editText9 = (EditText) findViewById(R.id.edittext_name1);
        editText10 = (EditText) findViewById(R.id.edittext_howlong);
        editText11 = (EditText) findViewById(R.id.edittext_more);

        //view for checkbox
        checkBox1 = (CheckBox) findViewById(R.id.checkbox_anemia);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox_Heartdisease);
        checkBox3 = (CheckBox) findViewById(R.id.checkbox_hbp);
        checkBox4 = (CheckBox) findViewById(R.id.checkbox_rheumaticfever);
        checkBox5 = (CheckBox) findViewById(R.id.checkbox_mitalvalve);
        checkBox6 = (CheckBox) findViewById(R.id.checkbox_thproblem);
        checkBox7 = (CheckBox) findViewById(R.id.checkbox_cancer);
        checkBox8 = (CheckBox) findViewById(R.id.checkbox_gallbladder);
        checkBox9 = (CheckBox) findViewById(R.id.checkbox_bloodtransfusion);
        checkBox10 = (CheckBox) findViewById(R.id.checkbox_pelvicinfection);
        checkBox11 = (CheckBox) findViewById(R.id.checkbox_bladderinfection);
        checkBox12 = (CheckBox) findViewById(R.id.checkbox_genitalherpes);
        checkBox13 = (CheckBox) findViewById(R.id.checkbox_seizures);
        checkBox14 = (CheckBox) findViewById(R.id.checkbox_migraines);
        checkBox15 = (CheckBox) findViewById(R.id.checkbox_liver);
        checkBox16 = (CheckBox) findViewById(R.id.checkbox_depression);
        checkBox17 = (CheckBox) findViewById(R.id.checkbox_drug);
        checkBox18 = (CheckBox) findViewById(R.id.checkbox_gonorrhea);
        checkBox19 = (CheckBox) findViewById(R.id.checkbox_asthma);
        checkBox20 = (CheckBox) findViewById(R.id.checkbox_pneumonia);
        checkBox21 = (CheckBox) findViewById(R.id.checkbox_diabetes);
        checkBox22 = (CheckBox) findViewById(R.id.checkbox_sicklecell);
        checkBox23 = (CheckBox) findViewById(R.id.checkbox_bloodclot);
        checkBox24 = (CheckBox) findViewById(R.id.checkbox_malaria);
        checkBox25 = (CheckBox) findViewById(R.id.checkbox_medicationyes);
        checkBox26 = (CheckBox) findViewById(R.id.checkbox_medicationno);
        checkBox27 = (CheckBox) findViewById(R.id.checkbox_allergiesyes);
        checkBox28 = (CheckBox) findViewById(R.id.checkbox_allergiesno);
        checkBox29 = (CheckBox) findViewById(R.id.checkbox_countryyes);
        checkBox30 = (CheckBox) findViewById(R.id.checkbox_countryno);
        checkBox31 = (CheckBox) findViewById(R.id.checkbox_chillsyes);
        checkBox32 = (CheckBox) findViewById(R.id.checkbox_chillsno);
        checkBox33 = (CheckBox) findViewById(R.id.checkbox_weightlossyes);
        checkBox34 = (CheckBox) findViewById(R.id.checkbox_weightlossno);
        checkBox35 = (CheckBox) findViewById(R.id.checkbox_headacheyes);
        checkBox36 = (CheckBox) findViewById(R.id.checkbox_headacheno);
        checkBox37 = (CheckBox) findViewById(R.id.checkbox_blurredyes);
        checkBox38 = (CheckBox) findViewById(R.id.checkbox_blurredno);
        checkBox39 = (CheckBox) findViewById(R.id.checkbox_doublevyes);
        checkBox40 = (CheckBox) findViewById(R.id.checkbox_doublevno);
        checkBox41 = (CheckBox) findViewById(R.id.checkbox_visionyes);
        checkBox42 = (CheckBox) findViewById(R.id.checkbox_visionno);
        checkBox43 = (CheckBox) findViewById(R.id.checkbox_hayfeveryes);
        checkBox44 = (CheckBox) findViewById(R.id.checkbox_hayfeverno);
        checkBox45 = (CheckBox) findViewById(R.id.checkbox_medicationnyes);
        checkBox46 = (CheckBox) findViewById(R.id.checkbox_medicationnno);
        checkBox47 = (CheckBox) findViewById(R.id.checkbox_dizzyes);
        checkBox48 = (CheckBox) findViewById(R.id.checkbox_dizzno);
        checkBox49 = (CheckBox) findViewById(R.id.checkbox_seizyes);
        checkBox50 = (CheckBox) findViewById(R.id.checkbox_seizno);
        checkBox51 = (CheckBox) findViewById(R.id.checkbox_numbyes);
        checkBox52 = (CheckBox) findViewById(R.id.checkbox_numbno);
        checkBox53 = (CheckBox) findViewById(R.id.checkbox_nauseayes);
        checkBox54 = (CheckBox) findViewById(R.id.checkbox_nauseano);
        checkBox55 = (CheckBox) findViewById(R.id.checkbox_constiyes);
        checkBox56 = (CheckBox) findViewById(R.id.checkbox_constino);
        checkBox57 = (CheckBox) findViewById(R.id.checkbox_abdomyes);
        checkBox58 = (CheckBox) findViewById(R.id.checkbox_abdomno);
        checkBox59 = (CheckBox) findViewById(R.id.checkbox_chestyes);
        checkBox60 = (CheckBox) findViewById(R.id.checkbox_chestno);
        checkBox61 = (CheckBox) findViewById(R.id.checkbox_diffyes);
        checkBox62 = (CheckBox) findViewById(R.id.checkbox_diffno);
        checkBox63 = (CheckBox) findViewById(R.id.checkbox_swellyes);
        checkBox64 = (CheckBox) findViewById(R.id.checkbox_swellno);
        checkBox65 = (CheckBox) findViewById(R.id.checkbox_palpyes);
        checkBox66 = (CheckBox) findViewById(R.id.checkbox_palpno);
        checkBox67 = (CheckBox) findViewById(R.id.checkbox_wheezyes);
        checkBox68 = (CheckBox) findViewById(R.id.checkbox_wheeztno);
        checkBox69 = (CheckBox) findViewById(R.id.checkbox_shortyes);
        checkBox70 = (CheckBox) findViewById(R.id.checkbox_shortno);
        checkBox71 = (CheckBox) findViewById(R.id.checkbox_coughyes);
        checkBox72 = (CheckBox) findViewById(R.id.checkbox_coughno);
        checkBox73 = (CheckBox) findViewById(R.id.checkbox_sleepyes);
        checkBox74 = (CheckBox) findViewById(R.id.checkbox_sleepno);
        checkBox75 = (CheckBox) findViewById(R.id.checkbox_jointyes);
        checkBox76 = (CheckBox) findViewById(R.id.checkbox_jointtno);
        checkBox77 = (CheckBox) findViewById(R.id.checkbox_muscleyes);
        checkBox78 = (CheckBox) findViewById(R.id.checkbox_muscleno);
        checkBox79 = (CheckBox) findViewById(R.id.checkbox_musclepyes);
        checkBox80 = (CheckBox) findViewById(R.id.checkbox_musclepno);
        checkBox81 = (CheckBox) findViewById(R.id.checkbox_soreyes);
        checkBox82 = (CheckBox) findViewById(R.id.checkbox_soreno);
        checkBox83 = (CheckBox) findViewById(R.id.checkbox_sinusyes);
        checkBox84 = (CheckBox) findViewById(R.id.checkbox_sinusno);
        checkBox85 = (CheckBox) findViewById(R.id.checkbox_hearyes);
        checkBox86 = (CheckBox) findViewById(R.id.checkbox_hearno);
        checkBox87 = (CheckBox) findViewById(R.id.checkbox_hotyes);
        checkBox88 = (CheckBox) findViewById(R.id.checkbox_hotno);
        checkBox89 = (CheckBox) findViewById(R.id.checkbox_excessyes);
        checkBox90 = (CheckBox) findViewById(R.id.checkbox_excessno);
        checkBox91 = (CheckBox) findViewById(R.id.checkbox_swollyes);
        checkBox92 = (CheckBox) findViewById(R.id.checkbox_swollno);
        checkBox93 = (CheckBox) findViewById(R.id.checkbox_freqyes);
        checkBox94 = (CheckBox) findViewById(R.id.checkbox_freqno);

        //data snapshot function
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // pushing user values to database
                String text1 = editText1.getText().toString().trim();
                String text2 = editText2.getText().toString().trim();
                String text3 = editText3.getText().toString().trim();
                String text4 = editText5.getText().toString().trim();
                String text5 = editText6.getText().toString().trim();
                String text6 = editText7.getText().toString().trim();
                String text7 = editText8.getText().toString().trim();
                String text8 = editText9.getText().toString().trim();
                String text9 = editText10.getText().toString().trim();
                String text10 = editText11.getText().toString().trim();
                int age = Integer.parseInt(editText4.getText().toString().trim());

                complaintmodel.setEdittextname(text1);
                complaintmodel.setEdittextaddress(text2);
                complaintmodel.setDate(text3);
                complaintmodel.setAge(age);
                complaintmodel.setEdittexthistory(text4);
                complaintmodel.setEdittextmedication(text5);
                complaintmodel.setEdittextallergies(text6);
                complaintmodel.setEdittextsymptoms(text7);
                complaintmodel.setEdittexttavelname(text8);
                complaintmodel.setEdittexthowlong(text9);
                complaintmodel.setEdittextcountries(text10);
                reference.child(String.valueOf(maxid+1)).setValue(complaintmodel);
                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();


                String text = "";
                if (checkBox1.isChecked()) {
                    reference.child("1").setValue("Anemia");
                    text = "Anemia";
                } else if (checkBox2.isChecked()) {
                    reference.child("2").setValue("Heart Disease");
                    text = "Heart Disease";
                } else if (checkBox3.isChecked()) {
                    reference.child("3").setValue("Heart Disease");
                    text = "High Blood Pressure";
                } else if (checkBox4.isChecked()) {

                    text = "Rheumatic Fever";
                } else if (checkBox5.isChecked()) {
                    text = "Mital Value Prolapse";
                } else if (checkBox6.isChecked()) {
                    text = "Th problem";
                } else if (checkBox7.isChecked()) {
                    text = "Cancer";
                } else if (checkBox8.isChecked()) {
                    text = "Gall Bladder Disease";
                } else if (checkBox9.isChecked()) {
                    text = "Blood Transfusion";
                } else if (checkBox10.isChecked()) {
                    text = "Pelvic Infection";
                } else if (checkBox11.isChecked()) {
                    text = "Bladdder Infection";
                } else if (checkBox12.isChecked()) {
                    text = "Genital Herpes";
                } else if (checkBox13.isChecked()) {
                    text = "Seizures";
                } else if (checkBox14.isChecked()) {
                    text = "Migraines";
                } else if (checkBox15.isChecked()) {
                    text = "Liver Disease";
                } else if (checkBox16.isChecked()) {
                    text = "Depression/Anxiety";
                } else if (checkBox17.isChecked()) {
                    text = "Drug or Alcohol Problem";
                } else if (checkBox18.isChecked()) {
                    text = "Gonorrhea/Syphills/Chlamydia";
                } else if (checkBox19.isChecked()) {
                    text = "Asthma";
                } else if (checkBox20.isChecked()) {
                    text = "Pneumonia";
                } else if (checkBox21.isChecked()) {
                    text = "Diabetes";
                } else if (checkBox22.isChecked()) {
                    text = "Sickel Cell Trait";
                } else if (checkBox23.isChecked()) {
                    text = "Blood clot in legs/lung";
                } else if (checkBox24.isChecked()) {
                    text = "Malaria";
                } else if (checkBox25.isChecked()) {
                    text = "Yes";
                } else if (checkBox26.isChecked()) {
                    text = "No";
                } else if (checkBox27.isChecked()) {
                    text = "Yes";
                } else if (checkBox28.isChecked()) {
                    text = "No";
                } else if (checkBox29.isChecked()) {
                    text = "Yes";
                } else if (checkBox30.isChecked()) {
                    text = "No";
                } else if (checkBox31.isChecked()) {
                    text = "Yes";
                } else if (checkBox32.isChecked()) {
                    text = "No";
                } else if (checkBox33.isChecked()) {
                    text = "Yes";
                } else if (checkBox34.isChecked()) {
                    text = "No";
                } else if (checkBox35.isChecked()) {
                    text = "Yes";
                } else if (checkBox36.isChecked()) {
                    text = "No";
                } else if (checkBox37.isChecked()) {
                    text = "Yes";
                } else if (checkBox38.isChecked()) {
                    text = "No";
                } else if (checkBox39.isChecked()) {
                    text = "Yes";
                } else if (checkBox40.isChecked()) {
                    text = "No";
                } else if (checkBox41.isChecked()) {
                    text = "Yes";
                } else if (checkBox42.isChecked()) {
                    text = "No";
                } else if (checkBox43.isChecked()) {
                    text = "Yes";
                } else if (checkBox44.isChecked()) {
                    text = "No";
                } else if (checkBox45.isChecked()) {
                    text = "Yes";
                } else if (checkBox46.isChecked()) {
                    text = "No";
                } else if (checkBox47.isChecked()) {
                    text = "Yes";
                } else if (checkBox48.isChecked()) {
                    text = "No";
                } else if (checkBox49.isChecked()) {
                    text = "Yes";
                } else if (checkBox50.isChecked()) {
                    text = "No";
                } else if (checkBox51.isChecked()) {
                    text = "Yes";
                } else if (checkBox52.isChecked()) {
                    text = "No";
                } else if (checkBox53.isChecked()) {
                    text = "Yes";
                } else if (checkBox54.isChecked()) {
                    text = "No";
                } else if (checkBox55.isChecked()) {
                    text = "Yes";
                } else if (checkBox56.isChecked()) {
                    text = "No";
                } else if (checkBox57.isChecked()) {
                    text = "Yes";
                } else if (checkBox58.isChecked()) {
                    text = "No";
                } else if (checkBox59.isChecked()) {
                    text = "Yes";
                } else if (checkBox60.isChecked()) {
                    text = "No";
                } else if (checkBox61.isChecked()) {
                    text = "Yes";
                } else if (checkBox62.isChecked()) {
                    text = "No";
                } else if (checkBox63.isChecked()) {
                    text = "Yes";
                } else if (checkBox64.isChecked()) {
                    text = "No";
                } else if (checkBox65.isChecked()) {
                    text = "Yes";
                } else if (checkBox66.isChecked()) {
                    text = "No";
                } else if (checkBox67.isChecked()) {
                    text = "Yes";
                } else if (checkBox68.isChecked()) {
                    text = "No";
                } else if (checkBox69.isChecked()) {
                    text = "Yes";
                } else if (checkBox70.isChecked()) {
                    text = "No";
                } else if (checkBox71.isChecked()) {
                    text = "Yes";
                } else if (checkBox72.isChecked()) {
                    text = "No";
                } else if (checkBox73.isChecked()) {
                    text = "Yes";
                } else if (checkBox74.isChecked()) {
                    text = "No";
                } else if (checkBox75.isChecked()) {
                    text = "Yes";
                } else if (checkBox76.isChecked()) {
                    text = "No";
                } else if (checkBox77.isChecked()) {
                    text = "Yes";
                } else if (checkBox78.isChecked()) {
                    text = "No";
                } else if (checkBox79.isChecked()) {
                    text = "Yes";
                } else if (checkBox80.isChecked()) {
                    text = "No";
                } else if (checkBox81.isChecked()) {
                    text = "Yes";
                } else if (checkBox82.isChecked()) {
                    text = "No";
                } else if (checkBox83.isChecked()) {
                    text = "Yes";
                } else if (checkBox84.isChecked()) {
                    text = "No";
                } else if (checkBox85.isChecked()) {
                    text = "Yes";
                } else if (checkBox86.isChecked()) {
                    text = "No";
                } else if (checkBox87.isChecked()) {
                    text = "Yes";
                } else if (checkBox88.isChecked()) {
                    text = "No";
                } else if (checkBox89.isChecked()) {
                    text = "Yes";
                } else if (checkBox90.isChecked()) {
                    text = "No";
                } else if (checkBox91.isChecked()) {
                    text = "Yes";
                } else if (checkBox92.isChecked()) {
                    text = "No";
                } else if (checkBox93.isChecked()) {
                    text = "Yes";
                } else if (checkBox94.isChecked()) {
                    text = "No";
                }
                reference.child(String.valueOf(maxid+1)).setValue(complaintmodel);
                Toast.makeText(getApplicationContext(),"Complaint sent Successfully",Toast.LENGTH_SHORT).show();

            }


        });

        editText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal =Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dpd = new DatePickerDialog(Complaints.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editText3.setText(dayOfMonth +"/" +(month+1) +"/"+year);
                    }
                },day, month, year);
                dpd.show();
            }
        });


    }
}
