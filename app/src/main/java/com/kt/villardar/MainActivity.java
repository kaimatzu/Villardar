package com.kt.villardar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.choice_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constLayout);
        constraintLayout.setBackgroundColor(Color.WHITE);
        myButtonListenerMethod();
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