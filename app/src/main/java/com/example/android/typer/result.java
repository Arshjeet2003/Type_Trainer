package com.example.android.typer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class result extends AppCompatActivity {

    TextView wrong_word;
    TextView wpm_tv_given;
    TextView review;
    TextView speed;
    ArrayList<String> wrong_words;
    ArrayList<String> correct_words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        wrong_word = findViewById(R.id.wrong_word);
        wpm_tv_given = findViewById(R.id.wpm_tv_given);
        review = findViewById(R.id.review_tv);
        speed = findViewById(R.id.speed);
        Intent intent = getIntent();
        wrong_words = intent.getStringArrayListExtra("wrong_words");
        correct_words = intent.getStringArrayListExtra("correct_words");
        double wpm = intent.getDoubleExtra("wpm",0.0);
        wpm_tv_given.setText(String.valueOf((int) wpm));
        setting_review(wrong_words.size());
        setting_speed((int)wpm);
        wrong_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> finalList;
                setting_final_list();
            }
        });

    }
    private void setting_final_list(){
        ArrayList<String> finalList = new ArrayList<>();
        int c=0;
        while (c<correct_words.size() && c<wrong_words.size()){
            finalList.add("       "+correct_words.get(c)+"        "+String.format("%38s",wrong_words.get(c)));
            c++;
        }
        Intent intent1 = new Intent(result.this,Wrong_words.class);
        intent1.putExtra("finalList",finalList);
        startActivity(intent1);
    }
    private void setting_review(int l){
        if(l==0){
            review.setText(R.string.no_errors);
        }
        else if(l<=5){
            review.setText(R.string.less_errors);
        }
        else if(l>5 && l<=20){
            review.setText(R.string.more_errors);
        }
        else{
            review.setText(R.string.many_errors);
        }
    }
    private void setting_speed(int wpm){
        if(wpm==0){
            speed.setText(R.string.slow_typer);
        }
        else if(wpm<=8 && wpm>0){
            speed.setText(R.string.improving_typer);
        }
        else if(wpm<=15 && wpm>8){
            speed.setText(R.string.good_typer);
        }
        else if(wpm<=20 && wpm>15){
            speed.setText(R.string.fast_typer);
        }
        else{
            speed.setText(R.string.typing_master);
        }
    }
        @Override
    public void onBackPressed() {
            Intent intent = new Intent(result.this,MainActivity.class);
            startActivity(intent);
    }
}