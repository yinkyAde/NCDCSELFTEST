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
import com.example.ncdc_selftest.Model.Medicalhistory;
import com.example.ncdc_selftest.Model.Symptoms;
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
    DatabaseReference reference1;
    Complaintmodel complaintmodel;
    DatabaseReference reference2;
    Medicalhistory medicalhistory;
    Symptoms symptoms;
    long maxid=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaints);
        reference = FirebaseDatabase.getInstance().getReference().child("Complaints");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Medical History");
        reference2 = FirebaseDatabase.getInstance().getReference().child("Symptoms");
        complaintmodel = new Complaintmodel();
        medicalhistory = new Medicalhistory();
        symptoms = new Symptoms();
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
                String text11 =   editText4.getText().toString().trim();

                complaintmodel.setEdittextname(text1);
                complaintmodel.setEdittextaddress(text2);
                complaintmodel.setDate(text3);
                complaintmodel.setAge(text11);
                complaintmodel.setEdittexthistory(text4);
                complaintmodel.setEdittextmedication(text5);
                complaintmodel.setEdittextallergies(text6);
                complaintmodel.setEdittextsymptoms(text7);
                complaintmodel.setEdittexttavelname(text8);
                complaintmodel.setEdittexthowlong(text9);
                complaintmodel.setEdittextcountries(text10);



                String text = "";
                if (checkBox1.isChecked()) {
                    medicalhistory.setAnemia("Anemia");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Anemia";
                } else {}
                if (checkBox2.isChecked()) {
                    medicalhistory.setHeartdisease("Heart Disease");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Heart Disease";
                } else{}
                if (checkBox3.isChecked()) {
                    medicalhistory.setHbp("High Blood Pressure");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "High Blood Pressure";
                } else{}
                if (checkBox4.isChecked()) {
                    medicalhistory.setRheumatic("Rheumatic Fever");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Rheumatic Fever";
                } else {}
                if (checkBox5.isChecked()) {
                    medicalhistory.setMital("Mital Value Prolapse");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Mital Value Prolapse";
                } else{}
                if (checkBox6.isChecked()) {
                    medicalhistory.setThprob("Th problem");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Th problem";
                } else{}
                if (checkBox7.isChecked()) {
                    medicalhistory.setCancer("Cancer");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Cancer";
                } else {}
                if (checkBox8.isChecked()) {
                    medicalhistory.setGall("Gall Bladder Disease");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Gall Bladder Disease";
                } else {}
                if (checkBox9.isChecked()) {
                    medicalhistory.setBloodtransfusion("Blood Transfusion");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Blood Transfusion";
                } else{}
                if (checkBox10.isChecked()) {
                    medicalhistory.setPelvic("Pelvic Infection");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Pelvic Infection";
                } else{}
                if (checkBox11.isChecked()) {
                    medicalhistory.setBladder("Bladdder Infection");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Bladdder Infection";
                } else {}
                if (checkBox12.isChecked()) {
                    medicalhistory.setGenital("Genital Herpes");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Genital Herpes";
                } else{}
                if (checkBox13.isChecked()) {
                    medicalhistory.setSeizure("Seizures");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Seizures";
                } else{}
                if (checkBox14.isChecked()) {
                    medicalhistory.setMigraines("Migraines");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Migraines";
                } else{}
                if (checkBox15.isChecked()) {
                    medicalhistory.setLiver("Liver Disease");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Liver Disease";
                } else {}
                if (checkBox16.isChecked()) {
                    medicalhistory.setDepression("Depression/Anxiety");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Depression/Anxiety";
                } else{}
                if (checkBox17.isChecked()) {
                    medicalhistory.setDrug("Drug or Alcohol Problem");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Drug or Alcohol Problem";
                } else {}
                if (checkBox18.isChecked()) {
                    medicalhistory.setGonorrhhea("Gonorrhea/Syphills/Chlamydia");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Gonorrhea/Syphills/Chlamydia";
                } else{}
                if (checkBox19.isChecked()) {
                    medicalhistory.setAsthma("Asthma");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Asthma";
                } else{}
                if (checkBox20.isChecked()) {
                    medicalhistory.setPneumonia("Pneumonia");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Pneumonia";
                } else{}
                if (checkBox21.isChecked()) {
                    medicalhistory.setDiabetes("Diabetes");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Diabetes";
                } else{}
                if (checkBox22.isChecked()) {
                    medicalhistory.setSickelcell("Sickel Cell Trait");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Sickel Cell Trait";
                } else{}
                if (checkBox23.isChecked()) {
                    medicalhistory.setBloodclot("Blood clot in legs/lung");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Blood clot in legs/lung";
                } else{}
                if (checkBox24.isChecked()) {
                    medicalhistory.setMalaria("Malaria");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Malaria";
                } else{}
                if (checkBox25.isChecked()) {
                    medicalhistory.setMedicationyes("Yes");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Yes";
                } else{}
                if (checkBox26.isChecked()) {
                    medicalhistory.setMedicationno("No");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "No";
                } else{}
                if (checkBox27.isChecked()) {
                    medicalhistory.setAllergiesyes("Yes");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Yes";
                } else{}
                if (checkBox28.isChecked()) {
                    medicalhistory.setAllergiesno("N0");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "No";
                } else{}
                if (checkBox29.isChecked()) {
                    medicalhistory.setTravelhistoryyes("Yes");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "Yes";
                } else{}
                if (checkBox30.isChecked()) {
                    medicalhistory.setTravelhistoryno("No");
                    reference1.child(String.valueOf((maxid+1))).setValue(medicalhistory);
                    text = "No";
                } else{}
                if (checkBox31.isChecked()) {
                    symptoms.setFeveryes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox32.isChecked()) {
                    symptoms.setFeverno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else {}
                if (checkBox33.isChecked()) {
                    symptoms.setWeightyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox34.isChecked()) {
                    symptoms.setWeightno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox35.isChecked()) {
                    symptoms.setHeadacheyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else {}
                if (checkBox36.isChecked()) {
                    symptoms.setHeadacheno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox37.isChecked()) {
                    symptoms.setBlurredyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else {}
                if (checkBox38.isChecked()) {
                    symptoms.setBlurredno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox39.isChecked()) {
                    symptoms.setDvisionyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox40.isChecked()) {
                    symptoms.setDvisionno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox41.isChecked()) {
                    symptoms.setVisionyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox42.isChecked()) {
                    symptoms.setVisionno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox43.isChecked()) {
                    symptoms.setHayfeveryes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox44.isChecked()) {
                    symptoms.setHayfeverno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox45.isChecked()) {
                    symptoms.setMedicationsyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox46.isChecked()) {
                    symptoms.setMedicationsno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox47.isChecked()) {
                    symptoms.setDizzyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox48.isChecked()) {
                    symptoms.setDizzno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox49.isChecked()) {
                    symptoms.setSeizuresyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox50.isChecked()) {
                    symptoms.setSeizuresno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox51.isChecked()) {
                    symptoms.setNumbnessyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox52.isChecked()) {
                    symptoms.setNumbnessno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox53.isChecked()) {
                    symptoms.setNauseayes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox54.isChecked()) {
                    symptoms.setNauseano("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox55.isChecked()) {
                    symptoms.setConstipationyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox56.isChecked()) {
                    symptoms.setConstipationno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox57.isChecked()) {
                    symptoms.setAbdominalpyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox58.isChecked()) {
                    symptoms.setAbdominalpno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox59.isChecked()) {
                    symptoms.setChestpyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox60.isChecked()) {
                    symptoms.setChestpno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox61.isChecked()) {
                    symptoms.setDiffbyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox62.isChecked()) {
                    symptoms.setDiffbno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox63.isChecked()) {
                    symptoms.setSwellingyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox64.isChecked()) {
                    symptoms.setSwellingno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox65.isChecked()) {
                    symptoms.setPalpitationsyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox66.isChecked()) {
                    symptoms.setPalpitationsno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox67.isChecked()) {
                    symptoms.setWheezyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox68.isChecked()) {
                    symptoms.setWheezno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox69.isChecked()) {
                    symptoms.setShortnessyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox70.isChecked()) {
                    symptoms.setShortnessno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox71.isChecked()) {
                    symptoms.setCoughyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox72.isChecked()) {
                    symptoms.setCoughno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox73.isChecked()) {
                    symptoms.setSleepyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox74.isChecked()) {
                    symptoms.setSleepno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox75.isChecked()) {
                    symptoms.setJointpyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox76.isChecked()) {
                    symptoms.setJointpno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox77.isChecked()) {
                    symptoms.setMusclewyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox78.isChecked()) {
                    symptoms.setMusclewno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox79.isChecked()) {
                    symptoms.setMusclepyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox80.isChecked()) {
                    symptoms.setMusclepno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox81.isChecked()) {
                    symptoms.setSorethroatyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox82.isChecked()) {
                    symptoms.setSorethroatno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox83.isChecked()) {
                    symptoms.setSinusyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox84.isChecked()) {
                    symptoms.setSinusno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox85.isChecked()) {
                    symptoms.setHearingpyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox86.isChecked()) {
                    symptoms.setHearingpno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox87.isChecked()) {
                    symptoms.setHotyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox88.isChecked()) {
                    symptoms.setHotno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox89.isChecked()) {
                    symptoms.setExcessyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox90.isChecked()) {
                    symptoms.setExcessno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox91.isChecked()) {
                    symptoms.setSwollenyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox92.isChecked()) {
                    symptoms.setSwollenno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                } else{}
                if (checkBox93.isChecked()) {
                    symptoms.setBruisingyes("Yes");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "Yes";
                } else{}
                if (checkBox94.isChecked()) {
                    symptoms.setBruisingno("No");
                    reference2.child(String.valueOf((maxid+1))).setValue(symptoms);
                    text = "No";
                }
                reference.child(String.valueOf(maxid+1)).setValue(complaintmodel);
                reference1.child(String.valueOf(maxid+1)).setValue(medicalhistory);
                reference2.child(String.valueOf(maxid+1)).setValue(symptoms);
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
