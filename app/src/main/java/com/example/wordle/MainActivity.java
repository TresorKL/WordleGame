package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    WGameProcessor processor = new WGameProcessor(this);
    Button submitWordBtn;
    int userChoice = 1;





    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<String> wordlist = processor.generateSpecificWordList(userChoice);
        // customize toolbar
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);



        // the word to be guessed
        String randomWord=processor.generateRandomWord(wordlist);
       // String randomWord=processor.generateRandomWord(wordlist);

        // accessing the submit button
        submitWordBtn= findViewById(R.id.submitWord);

        // event listener of the submit button
        submitWordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // row counter
              int rowCount=0;


              while(rowCount!=5) {

                  String word=  getSpecificRowWord(rowCount);
                  for (int i = 0; i < word.length(); i++) {
                      char letter = word.charAt(i);
                      if (randomWord.charAt(i) == letter) {

                          setColorLetterExistCorrectPosition(rowCount, i);


                      } else if (randomWord.indexOf(letter) != -1) {

                          setColorLetterExistWrongPosition(rowCount, i);

                      } else {


                          setColorLetterDosnotExist(rowCount, i);
                          // Toast.makeText(MainActivity.this,"WRONG", Toast.LENGTH_SHORT).show();
                      }
                  }
                  Toast.makeText(MainActivity.this,randomWord, Toast.LENGTH_SHORT).show();
                  rowCount++;

                  // Toast.makeText(MainActivity.this,word, Toast.LENGTH_SHORT).show();
              }
            }
        });
        



    }

//------------------------------------------------------------------------------------------------------
    // this method helps to create the menu options
//------------------------------------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


//------------------------------------------------------------------------------------------------------
    // this method retrieve a word from a specific row of letters
//------------------------------------------------------------------------------------------------------

    public String getSpecificRowWord(int rowN0){


        String word="";
        String [][]ids = {
                {"r1c1","r1c2","r1c3","r1c4","r1c5"},
                {"r2c1","r2c2","r2c3","r2c4","r2c5"},
                {"r3c1","r3c2","r3c3","r3c4","r3c5"},
                {"r4c1","r4c2","r4c3","r4c4","r4c5"},
                {"r5c1","r5c2","r5c3","r5c4","r5c5"}
        };

        for(int i=0;i<5;i++){
            // current id name from ids array
            String currentId =ids[rowN0][i];


            int resID = getResources().getIdentifier(currentId,
                    "id", getPackageName());

           EditText letter = findViewById(resID);


           // creating the word by concatenating the letters
            word= word.concat(letter.getText().toString()) ;

        }


      return word.toLowerCase();
    }
//------------------------------------------------------------------------------------------------------
    // this method helps to style the editText(change the background) if the letter exists in the word and
    // it is in the correct position
//------------------------------------------------------------------------------------------------------
    public void setColorLetterExistCorrectPosition(int rowNo, int column){
        //array of all the ids names
        String [][]ids = {
                {"r1c1","r1c2","r1c3","r1c4","r1c5"},
                {"r2c1","r2c2","r2c3","r2c4","r2c5"},
                {"r3c1","r3c2","r3c3","r3c4","r3c5"},
                {"r4c1","r4c2","r4c3","r4c4","r4c5"},
                {"r5c1","r5c2","r5c3","r5c4","r5c5"}
        };

        String currentId =ids[rowNo][column];


        int resID = getResources().getIdentifier(currentId,
                "id", getPackageName());

        EditText letter = findViewById(resID);
        Drawable green = getResources().getDrawable(R.drawable.letterexit_correct_position);
        letter.setBackground(green);

    }
//------------------------------------------------------------------------------------------------------
    // this method helps to style the editText(change the background) if the letter exists in the word BUT
    // it is in the wrong position
//------------------------------------------------------------------------------------------------------
    public void setColorLetterExistWrongPosition(int rowNo, int column){
        String [][]ids = {
                {"r1c1","r1c2","r1c3","r1c4","r1c5"},
                {"r2c1","r2c2","r2c3","r2c4","r2c5"},
                {"r3c1","r3c2","r3c3","r3c4","r3c5"},
                {"r4c1","r4c2","r4c3","r4c4","r4c5"},
                {"r5c1","r5c2","r5c3","r5c4","r5c5"}
        };

        String currentId =ids[rowNo][column];


        int resID = getResources().getIdentifier(currentId,
                "id", getPackageName());

        EditText letter = findViewById(resID);
        Drawable green = getResources().getDrawable(R.drawable.letterexist_wrongposition);
        letter.setBackground(green);

    }
//------------------------------------------------------------------------------------------------------
    // this method helps to style the editText(change the background) if the letter doesn't exist in the word and
//------------------------------------------------------------------------------------------------------
    public void setColorLetterDosnotExist(int rowNo, int column){
        String [][]ids = {
                {"r1c1","r1c2","r1c3","r1c4","r1c5"},
                {"r2c1","r2c2","r2c3","r2c4","r2c5"},
                {"r3c1","r3c2","r3c3","r3c4","r3c5"},
                {"r4c1","r4c2","r4c3","r4c4","r4c5"},
                {"r5c1","r5c2","r5c3","r5c4","r5c5"}
        };

        String currentId =ids[rowNo][column];


        int resID = getResources().getIdentifier(currentId,
                "id", getPackageName());

        EditText letter = findViewById(resID);
        Drawable green = getResources().getDrawable(R.drawable.letter_doesnot_exist);
        letter.setBackground(green);

    }



}

