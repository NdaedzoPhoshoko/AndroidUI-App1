package com.example.uibasics2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton rb1 = findViewById(R.id.rb1);
        RadioButton rb2 = findViewById(R.id.rb2);
        RadioButton rb3 = findViewById(R.id.rb3);
        RadioGroup maritalStatus = findViewById(R.id.radioGroup1);
        //pb1 = findViewById(R.id.progressBar1);
        ProgressBar pb2 = findViewById(R.id.progressBar2);
        Button load1 = findViewById(R.id.loadButton1);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int a=0; a<10; a++)
                {
                    pb2.incrementProgressBy(10);
                    /*if(pb2.getProgress()==100)
                    {
                        Toast.makeText(MainActivity.this, "Finished Loading", Toast.LENGTH_SHORT).show();
                    }*/
                    SystemClock.sleep(1000);// use Thread.sleep(4000); with try...catch() block
                }
                //pb2.setProgress(0); //set progress to zero, to prevent incrementing above 100 progress
            }
        });

        int checkedButtonId = maritalStatus.getCheckedRadioButtonId(); //returns id of the button that is checked
        switch(checkedButtonId) //display the Toast of the checkedButton
        {
            case R.id.rb1:
                Toast.makeText(this, "Single", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb2:
                Toast.makeText(this,"Married", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb3:
                Toast.makeText(this, "In a Relationship", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Choose your Status", Toast.LENGTH_SHORT).show();
                break;
        }

        maritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch(id)
                {
                    case R.id.rb1:
                    Toast.makeText(MainActivity.this, "Single selected", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.rb2:
                        Toast.makeText(MainActivity.this,"Married selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb3:
                        Toast.makeText(MainActivity.this, "In a Relationship selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        load1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pb2.getVisibility()==View.VISIBLE) //if user clicks second time, then disappears
                {
                    pb2.setVisibility(View.INVISIBLE);  //pb1.setVisibility(View.GONE);
                    load1.setText("Load".toUpperCase());
                }else //if user clicks first time then progressBar appears
                {
                    thread.start(); //calls run in the Runnable interface
                    pb2.setVisibility(View.VISIBLE); //setting ProgressBar to appear
                    load1.setText("Stop".toUpperCase());
                }
            }
        });
    }
}