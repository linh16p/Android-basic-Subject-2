package com.example.mybasicuicontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageButton ib;
    Button nut,nut1,nut2;

    CheckBox cb1,cb2;
    AutoCompleteTextView atc;

    ToggleButton tb1,tb2;
    RadioGroup rg1;
    RadioButton rb1;
    TimePicker tp;
    TextView time;
    Calendar calendar;
    String format = "";

    public void setTime(View view){
        int hour = tp.getHour();
        int min = tp.getMinute();
        showTime(hour,min);
    }
    public void showTime(int hour, int min){
        if(hour == 0){
            hour +=12;
            format = "AM";
        }else if(hour == 12){
            format = "PM";
        }else if(hour>12){
            hour -=12;
            format = "PM";
        }else{
            format = "AM";
        }
        time.setText(new StringBuilder().append(hour).append(" : ").append(min).append(" ").append(format));
    }

    String[] arr = {"Paries,France", "PA,United States","Parana,Brazil", "Padua,Italy", "Pasadena,CA,United States"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ib = (ImageButton) findViewById(R.id.imageButton);
        atc = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        cb1 = (CheckBox) findViewById(R.id.checkbox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        nut = (Button) findViewById(R.id.button);
        nut1 = (Button) findViewById(R.id.button2);
        tb1 = (ToggleButton)findViewById(R.id.toggleButton);
        tb2 = (ToggleButton)findViewById(R.id.toggleButton2);
        // radio group and radio button
        nut2 = (Button) findViewById(R.id.button3);
        rg1 = (RadioGroup)findViewById(R.id.radiogroup);
        // spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setPrompt("Select one");

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Cute Image",Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr);
        atc.setThreshold(2);
        atc.setAdapter(adapter);

        nut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("Thanks: ").append(cb1.isChecked());
                result.append("\nThanks: ").append(cb2.isChecked());
                Toast.makeText(MainActivity.this,result.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result1 = new StringBuffer();
                result1.append("you have clickes first On Button -:").append(tb1.getText());
                result1.append("\nyou have clicked second On button -:").append(tb2.getText());
                Toast.makeText(MainActivity.this,result1.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seclected = rg1.getCheckedRadioButtonId(); // lay id cua nut duoc checked
                rb1 = (RadioButton) findViewById(seclected); // gan id cho nut nay
                Toast.makeText(MainActivity.this,rb1.getText(),Toast.LENGTH_LONG).show();
            }
        });

        tp = (TimePicker) findViewById(R.id.timepicker);
        time = (TextView) findViewById(R.id.tv5);
        calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour,min);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}