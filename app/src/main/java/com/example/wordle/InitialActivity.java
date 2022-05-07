package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class InitialActivity extends AppCompatActivity {

    Button startGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

         startGame = findViewById(R.id.startGame);
        Spinner spinner = (Spinner)findViewById(R.id.mySpinser);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String> (InitialActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.files));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText userName =(EditText)findViewById(R.id.userName);

                if( TextUtils.isEmpty(userName.getText())){

                    userName.setError( "First name is required!" );

                }else{
                    Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainActivity);
                }

            }
        });


    }
}