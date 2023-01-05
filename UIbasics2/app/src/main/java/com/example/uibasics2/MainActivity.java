package com.example.uibasics2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Object declarations
    private CheckBox cbILostYou, cbDontGo, cbBlackSinister, cbDislikeMe;
    private RadioGroup rgMaritalStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbBlackSinister = findViewById(R.id.cbBlackSinister);
        cbDislikeMe = findViewById(R.id.cbDislikeMe);
        cbDontGo = findViewById(R.id.cbDontGo);
        cbILostYou = findViewById(R.id.cbILostYou);

        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId)
                {
                    case R.id.rbDivorced:
                        Toast.makeText(MainActivity.this, "Divorced", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        if(cbBlackSinister.isChecked())
        {
            Toast.makeText(MainActivity.this, "Black Sinister was selected", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Black Sinister was not selected", Toast.LENGTH_SHORT).show();
        }
        cbBlackSinister.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(MainActivity.this, "You have selected Black Sinister", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //....
    }
}