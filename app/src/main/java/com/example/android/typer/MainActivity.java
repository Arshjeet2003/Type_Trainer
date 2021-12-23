package com.example.android.typer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    TextView text_tv;
    TextView enter_text;
    TextView basic;
    TextView intermediate;
    TextView hard;
    ImageView timer;
    TextView timer_text;
    TextView swipe;
    int count=0;

    String sentences[];
    ArrayList<String> wrong_words = new ArrayList<>();
    ArrayList<String> correct_words = new ArrayList<>();
    long tStart; long tEnd;
    int total_words = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_tv = findViewById(R.id.text_tv);
        enter_text = findViewById(R.id.enter_text);
        basic = findViewById(R.id.basic_training);
        intermediate = findViewById(R.id.intermediate_training);
        hard = findViewById(R.id.hard_training);
        timer = findViewById(R.id.timer);
        timer_text = findViewById(R.id.timer_text);
        swipe = findViewById(R.id.swipe);
        SharedPreferences preferences = getSharedPreferences("training_type",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("type",1);
                editor.apply();
                basic.setVisibility(View.GONE);
                intermediate.setVisibility(View.GONE);
                hard.setVisibility(View.GONE);
                timer.setVisibility(View.VISIBLE);
                timer_text.setVisibility(View.VISIBLE);
            }
        });
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("type",2);
                editor.apply();
                basic.setVisibility(View.GONE);
                intermediate.setVisibility(View.GONE);
                hard.setVisibility(View.GONE);
                timer.setVisibility(View.VISIBLE);
                timer_text.setVisibility(View.VISIBLE);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("type",3);
                editor.apply();
                basic.setVisibility(View.GONE);
                intermediate.setVisibility(View.GONE);
                hard.setVisibility(View.GONE);
                timer.setVisibility(View.VISIBLE);
                timer_text.setVisibility(View.VISIBLE);
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setVisibility(View.GONE);
                timer_text.setVisibility(View.GONE);
                tStart = System.currentTimeMillis();
                sentences = setting_sentences(preferences.getInt("type",0));
                setting_text();
                text_tv.setVisibility(View.VISIBLE);
                enter_text.setVisibility(View.VISIBLE);
            }
        });
        swipe.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                show_next_data();
            }
        });
        swipe.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                show_next_data();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if (menuItem.getItemId() == R.id.result) {
            show_result();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void show_result() {
        double time_sec = getTimeTaken();
        double min = time_sec/60.0;
        double wpm = Math.rint(total_words/min);
        Intent intent = new Intent(MainActivity.this,result.class);
        intent.putExtra("wrong_words",wrong_words);
        intent.putExtra("correct_words",correct_words);
        intent.putExtra("wpm",wpm);
        startActivity(intent);
        if(!enter_text.getText().toString().equals("")){
            count++;
        }
    }

    private void show_next_data() {
        String[] Data_text = get_data_text();
        String[] Entered_text = get_text_from_enteredData();
        int c = 0;
        while (c!=Data_text.length && c!=Entered_text.length){
            if(!Entered_text[c].equals(Data_text[c])){
                wrong_words.add(Entered_text[c]);
                correct_words.add(Data_text[c]);
            }
            c++;
        }
        setting_text();
    }
    private String[] get_text_from_enteredData(){
        String entered_text = " "+enter_text.getText().toString()+" ";
        StringTokenizer st1 = new StringTokenizer(entered_text,".,?! ");
        int n1 = st1.countTokens();
        total_words += n1;
        int j=0;
        String[] entered_words = new String[n1];
        while (st1.hasMoreTokens()){
            entered_words[j]=st1.nextToken();
            j++;
        }
        return entered_words;
    }
    private String[] get_data_text(){
        String raw_text = " "+text_tv.getText().toString()+" ";
        StringTokenizer st = new StringTokenizer(raw_text,".,?! ");
        int n = st.countTokens();
        int i=0;
        String[] words = new String[n];
        while (st.hasMoreTokens()){
            words[i]=st.nextToken();
            i++;
        }
        return words;
    }
    private void setting_text(){
        text_tv.setText(sentences[count]);
        enter_text.setText("");
        if(count<sentences.length) {
            count++;
        }
    }
    private double getTimeTaken(){
        tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double time_in_sec = (double) tDelta/1000;
        return time_in_sec;
    }
    private String[] setting_sentences(int i){
        data obj = new data();
        return obj.sentences_array(i);
    }
//    @Override
//    public void onBackPressed() {
//        tStart = System.currentTimeMillis();
//        wrong_words.clear();
//        correct_words.clear();
//        total_words=0;
//        Toast.makeText(getApplicationContext(),"working",Toast.LENGTH_SHORT).show();
//    }
}
