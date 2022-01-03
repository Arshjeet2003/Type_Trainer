package com.example.android.typer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    TextView text_tv;
    EditText enter_text;
    TextView basic;
    TextView intermediate;
    TextView hard;
    ImageView timer;
    TextView timer_text;
    TextView swipe;
    int count;

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
        MyKeyboard keyboard = findViewById(R.id.keyboard);
        enter_text.setShowSoftInputOnFocus(false);
        enter_text.setRawInputType(InputType.TYPE_CLASS_TEXT);
        enter_text.setTextIsSelectable(true);
        InputConnection ic = enter_text.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);

        SharedPreferences preferences1 = getSharedPreferences("sentences_count",MODE_PRIVATE);
        count = preferences1.getInt("count",0);

        SharedPreferences preferences = getSharedPreferences("training_type",MODE_PRIVATE);

        int value = preferences.getInt("type",0);
        if(value!=0){
            basic.setVisibility(View.GONE);
            intermediate.setVisibility(View.GONE);
            hard.setVisibility(View.GONE);
            timer.setVisibility(View.VISIBLE);
            timer_text.setVisibility(View.VISIBLE);
        }
        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
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
                SharedPreferences.Editor editor = preferences.edit();
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
                SharedPreferences.Editor editor = preferences.edit();
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
                total_words=0;
                sentences = setting_sentences(preferences.getInt("type",0));
                setting_text(0);
                text_tv.setVisibility(View.VISIBLE);
                enter_text.setVisibility(View.VISIBLE);
                keyboard.setVisibility(View.VISIBLE);
            }
        });
        swipe.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
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
        switch (menuItem.getItemId()){
            case R.id.result:
                show_result();
                break;
            case R.id.reset:
                reset_data();
                break;
            case R.id.settings:
                Intent intent = new Intent(this,Settings.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(menuItem);
    }
    private void reset_data() {
        SharedPreferences preferences = getSharedPreferences("training_type",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        SharedPreferences preferences1 = getSharedPreferences("sentences_count",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = preferences1.edit();
        editor1.clear();
        editor1.apply();
        recreate();
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
        SharedPreferences preferences = getSharedPreferences("sentences_count", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("count", count);
        editor.apply();
        String[] Data_text = get_data_text();
        String[] Entered_text = get_text_from_enteredData();
        int c = 0; int k=0;
        while (c!=Data_text.length && c!=Entered_text.length){
            if(!Entered_text[c].equals(Data_text[c])){
                k++;
                wrong_words.add(Entered_text[c]);
                correct_words.add(Data_text[c]);
            }
            c++;
        }
        setting_text(k);
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
    private void setting_text(int k){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        setting_audio(sharedPreferences,k);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        text_tv.setText(sentences[count].toLowerCase().trim());
        enter_text.setText("");
        if(count<sentences.length) {
            count++;
        }
        else{
            reset_data();
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
    private void setting_audio(SharedPreferences sharedPreferences,int k) {
        String sound = sharedPreferences.getString(getResources().getString(R.string.soundList_key),getString(R.string.chime1));
        if(k==0){
            if(sound.equals(getResources().getString(R.string.chime1))) {
                MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.chime1);
                music.start();
            }
            else if(sound.equals(getResources().getString(R.string.chime2))){
                MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.chime2);
                music.start();
            }
        }
    }
    private void setupSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        loadFontFromPreference(sharedPreferences);
        sharedPreferences.registerOnSharedPreferenceChangeListener(MainActivity.this);
    }
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        if(key.equals(getResources().getString(R.string.soundList_key))){
            setting_audio(sharedPreferences,0);
        }
        else if(key.equals(getResources().getString(R.string.font_key))){
            setting_fontSize(sharedPreferences);
        }
        else if(key.equals(getResources().getString(R.string.fontType_key))){
            loadFontFromPreference(sharedPreferences);
        }
    }

    private void loadFontFromPreference(SharedPreferences sharedPreferences){
        String font = sharedPreferences.getString(getResources().getString(R.string.fontType_key),getString(R.string.playfair_font));

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            if(font.equals(getResources().getString(R.string.aargh_font))) {
                Typeface typeface = getResources().getFont(R.font.aargh);
                set_font(typeface);
            }
            else if(font.equals(getResources().getString(R.string.adamina_font))){
                Typeface typeface = getResources().getFont(R.font.adamina_regular);
                set_font(typeface);
            }
            else if(font.equals(getResources().getString(R.string.damion_font))){
                Typeface typeface = getResources().getFont(R.font.damion_regular);
                set_font(typeface);
            }
            else if(font.equals(getResources().getString(R.string.licorice_font))){
                Typeface typeface = getResources().getFont(R.font.licorice_regular);
                set_font(typeface);
            }
            else if(font.equals(getResources().getString(R.string.monospace_font))){
                Typeface typeface = getResources().getFont(R.font.monospace);
                set_font(typeface);
            }
            else if(font.equals(getResources().getString(R.string.playfair_font))){
                Typeface typeface = getResources().getFont(R.font.playfair);
                set_font(typeface);
            }
            else if(font.equals(getResources().getString(R.string.shizuru_font))){
                Typeface typeface = getResources().getFont(R.font.shizuru_regular);
                set_font(typeface);
            }
            else if(font.equals(getResources().getString(R.string.ubuntu_font))){
                Typeface typeface = getResources().getFont(R.font.ubuntu_light);
                set_font(typeface);
            }

        }
    }

    private void set_font(Typeface typeface) {
        text_tv.setTypeface(typeface);
        enter_text.setTypeface(typeface);
        basic.setTypeface(typeface);
        intermediate.setTypeface(typeface);
        hard.setTypeface(typeface);
        timer_text.setTypeface(typeface);
    }

    private void setting_fontSize(SharedPreferences sharedPreferences) {
        String font_size = sharedPreferences.getString(getResources().getString(R.string.font_key),getString(R.string.default_font_size));
        int fontSize = Integer.parseInt(font_size);
        text_tv.setTextSize(fontSize);
        enter_text.setTextSize(fontSize);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //To prevent memory leak
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }
}
