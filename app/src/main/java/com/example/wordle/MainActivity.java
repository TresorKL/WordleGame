package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submitWordBtn;
    // access all the edittexts



    /*  EditText r1c1 = findViewById(R.id.r1c1);
    EditText r1c2 = findViewById(R.id.r1c2);
    EditText r1c3 = findViewById(R.id.r1c3);
    EditText r1c4 = findViewById(R.id.r1c4);
    EditText r1c5 = findViewById(R.id.r1c5);



      String r1c1Str = r1c1.getText().toString();
                String r1c2Str = r1c2.getText().toString();
                String r1c3Str = r1c3.getText().toString();
                String r1c4Str = r1c4.getText().toString();
                String r1c5Str = r1c5.getText().toString();

                String wordStr =r1c1Str+r1c2Str+r1c3Str+r1c4Str+r1c5Str;
                String[] word={r1c1Str,r1c2Str,r1c3Str,r1c4Str,r1c5Str};
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String randomWord="TRESO";

        submitWordBtn= findViewById(R.id.submitWord);

        submitWordBtn.setOnClickListener(new View.OnClickListener() {
            int count =1 ;
            @Override
            public void onClick(View view) {


              String word=  getSpecificRowWord(0);


                  for (int i=0;i< word.length();i++){
                      char letter = word.charAt(i);
                      if(randomWord.charAt(i)==letter){
                          int index= randomWord.indexOf(letter);
                          setColorLetterExistCorrectPosition(0, index);


                      }else if(randomWord.indexOf(letter)!=-1){
                          int index= randomWord.indexOf(letter);
                          setColorLetterExistWrongPosition(0,index);

                      }else{

                      }
                  }
             // }

              Toast.makeText(MainActivity.this,word, Toast.LENGTH_SHORT).show();

            }
        });
        



    }

    // this method retrieve a word from a specific row of letters
    public String getSpecificRowWord(int rowN0){


        String word="";
        String [][]ids = {
                {"r1c1","r1c2","r1c3","r1c4","r1c5"},
                {"r2c1","r2c2","r2c3","r2c4","r2c5"},
                {"r3c1","r3c2","r3c3","r3c4","r3c5"},
                {"r4c1","r4c2","r4c3","r4c4","r5c5"},
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


      return word;
    }

    public void setColorLetterExistCorrectPosition(int rowNo, int column){
        String [][]ids = {
                {"r1c1","r1c2","r1c3","r1c4","r1c5"},
                {"r2c1","r2c2","r2c3","r2c4","r2c5"},
                {"r3c1","r3c2","r3c3","r3c4","r3c5"},
                {"r4c1","r4c2","r4c3","r4c4","r5c5"},
                {"r5c1","r5c2","r5c3","r5c4","r5c5"}
        };

        String currentId =ids[rowNo][column];


        int resID = getResources().getIdentifier(currentId,
                "id", getPackageName());

        EditText letter = findViewById(resID);
        Drawable green = getResources().getDrawable(R.drawable.letterexit_correct_position);
        letter.setBackground(green);

    }
    public void setColorLetterExistWrongPosition(int rowNo, int column){
        String [][]ids = {
                {"r1c1","r1c2","r1c3","r1c4","r1c5"},
                {"r2c1","r2c2","r2c3","r2c4","r2c5"},
                {"r3c1","r3c2","r3c3","r3c4","r3c5"},
                {"r4c1","r4c2","r4c3","r4c4","r5c5"},
                {"r5c1","r5c2","r5c3","r5c4","r5c5"}
        };

        String currentId =ids[rowNo][column];


        int resID = getResources().getIdentifier(currentId,
                "id", getPackageName());

        EditText letter = findViewById(resID);
        Drawable green = getResources().getDrawable(R.drawable.letterexist_wrongposition);
        letter.setBackground(green);

    }



}

