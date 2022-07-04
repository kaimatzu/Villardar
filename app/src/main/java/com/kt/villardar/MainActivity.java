package com.kt.villardar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.userTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.choice_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        userTypeChangeListenerMethod(this);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constLayout);
        constraintLayout.setBackgroundColor(Color.WHITE);
        dayToggleSwitchListenerMethod();
        myButtonListenerMethod();
    }

    public void dayToggleSwitchListenerMethod(){
        Switch sw = (Switch) findViewById(R.id.switchDayToggle);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constLayout);
        TextView title = (TextView) findViewById(R.id.title);
        TextView name = (TextView) findViewById(R.id.name);
        EditText etName = (EditText) findViewById(R.id.nameTextBox);
        CheckBox cbCIT = (CheckBox) findViewById(R.id.fromCITCheckBox);
        Spinner spUsertype = (Spinner) findViewById(R.id.userTypeSpinner);
        RadioButton rbMale = (RadioButton) findViewById(R.id.maleRadioButton);
        RadioButton rbFemale = (RadioButton) findViewById(R.id.femaleRadioButton);
        RadioButton rbFirst = (RadioButton) findViewById(R.id.firstYearRadioButton);
        RadioButton rbSecond = (RadioButton) findViewById(R.id.secondYearRadioButton);
        RadioButton rbThird = (RadioButton) findViewById(R.id.thirdYearRadioButton);
        RadioButton rbFourth = (RadioButton) findViewById(R.id.fourthYearRadioButton);

        TextView[] texts = {sw, cbCIT, rbMale, rbFemale, rbFirst, rbSecond, rbThird, rbFourth, title, name, etName};
        sw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constLayout);

                if(sw.isChecked()) {
                    constraintLayout.setBackgroundColor(Color.WHITE);
                    for (TextView tv : texts) {
                        tv.setTextColor(Color.BLACK);
                    }
                }
                else {
                    constraintLayout.setBackgroundColor(Color.BLACK);
                    for (TextView tv : texts) {
                        tv.setTextColor(Color.WHITE);
                    }
                }
            }
        });
    }

    public void userTypeChangeListenerMethod(Context c) {
        Spinner userTypeSpinner = (Spinner) findViewById(R.id.userTypeSpinner);
        userTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = (String) userTypeSpinner.getItemAtPosition(i);
                Toast.makeText(c, "You have selected " + selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void myButtonListenerMethod(){
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constLayout);
                int color = ((ColorDrawable)constraintLayout.getBackground()).getColor();
                if(color == Color.RED)
                    constraintLayout.setBackgroundColor(Color.WHITE);
                else
                    constraintLayout.setBackgroundColor(Color.RED);
            }
        });
    }
}