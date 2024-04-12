package com.virak.dialogfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView displayTextView=(TextView)findViewById(R.id.displayTextView);

        Button simpleButton = (Button) findViewById(R.id.simpleDiaglogButton);
        simpleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                SimpleDialogFragment simpleDialog=new SimpleDialogFragment();
                simpleDialog.show(getSupportFragmentManager(), "simpleDialog");

            }
        });

        Button customButton = (Button) findViewById(R.id.customDialogButton);
        customButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                CustomDialogFragment customDialog=new CustomDialogFragment();
                customDialog.show(getSupportFragmentManager(), "customeDialog");

            }
        });




        Button datePickerButton = (Button) findViewById(R.id.dateDialogButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                displayTextView.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePicker.show();


            }
        });

        Button timePickerButton = (Button) findViewById(R.id.timePickerButton);
        timePickerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int sHour, int sMinute) {
                                displayTextView.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                timePickerDialog.show();

            }
        });


    }
}