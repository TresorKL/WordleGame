package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class InitialActivity extends AppCompatActivity {

    Button startGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);


         startGame = findViewById(R.id.startGame);

        RadioGroup radioGroup =(RadioGroup)findViewById(R.id.files);





        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userChoiceStr = "File 1";

                int fileSelected = radioGroup.getCheckedRadioButtonId();

                if(fileSelected==R.id.file2){

                    userChoiceStr = "File 2";
                }

                EditText userName =(EditText)findViewById(R.id.userName);

                String userNameStr=userName.getText().toString();

                if( TextUtils.isEmpty(userName.getText())){

                    userName.setError( "First name is required!" );

                }else{
                    Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                    mainActivity.putExtra("userChoice", userChoiceStr);
                    mainActivity.putExtra("userName", userNameStr);
                    startActivity(mainActivity);
                }

            }
        });


    }
}