package com.example.uibasics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declaration of UI elements
    private EditText editTxt;
    private TextView displayName;
    Button helloBtn1, clearBtn;

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.helloButton:
                if(editTxt.getText().length()<=0)
                {
                    editTxt.setHint("please enter name");
                    editTxt.setHintTextColor(Color.parseColor("Red"));

                }else{
                    displayName.setText("Name: "+ editTxt.getText().toString());
                }
                break;
            case R.id.helloButton2:
                if(editTxt.getText().length()<=0) {
                    Toast.makeText(this, "Nothing to clear", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Name cleared", Toast.LENGTH_SHORT).show();
                    editTxt.setText("");
                    editTxt.setHintTextColor(Color.parseColor("grey"));
                    editTxt.setHint("Name");
                    displayName.setText("Hello Again");
                }
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate UI elements
        editTxt = findViewById(R.id.editTxt);
        displayName = findViewById(R.id.text2);
        helloBtn1 = findViewById(R.id.helloButton);
        clearBtn = findViewById(R.id.helloButton2);
        helloBtn1.setOnClickListener(this::onClick);
        clearBtn.setOnClickListener(this::onClick);


    }
}
/*
    public void onButtonClick(View view) {
        TextView txtWelcome = findViewById(R.id.textWelcome);
        txtWelcome.setText("Button Clicked!");
    }*/
/*
        Button btn = findViewById(R.id.helloButton2);
        btn.setOnLongClickListener(view -> {
            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            return true;
        });
        */
/*
    btn.setOnLongClickListener(view -> {
            Toast.makeText(MainActivity.this, "Long Click Happened", Toast.LENGTH_SHORT).show();
            return true;
        });*/
/*Button button2 = findViewById(R.id.helloButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               button2.setText("Hey what is up");
            }
        });*/