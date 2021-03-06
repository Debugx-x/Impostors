package com.vaibhavs.MineSweeper.UI;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vaibhavs.MineSweeper.R;
import com.vaibhavs.MineSweeper.model.Minesfield;

/**
 * The main menu screen of the game used to launch the game or access option and help menu screens
 */
public class Main_menu extends AppCompatActivity {

    Minesfield mf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mf = Minesfield.getInstance();

        Intent_buttons();
    }

    void Intent_buttons(){
        Button play_btn = findViewById(R.id.btn_play);
        final MediaPlayer option = MediaPlayer.create(this,R.raw.option_btn);
        final MediaPlayer Play = MediaPlayer.create(this,R.raw.play_game);
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play.start();
                // increment no of games played
                mf.setTimes_played(mf.getTimes_played()+1);
                Toast.makeText(Main_menu.this,"Launching Game Screen",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Main_menu.this,game.class);
                startActivity(intent);
            }
        });
        Button option_btn = findViewById(R.id.btn_options);
        option_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option.start();
                Toast.makeText(Main_menu.this,"Launching options Screen",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Main_menu.this,option.class);
                startActivity(i);
            }
        });
        Button help_btn = findViewById(R.id.btn_help);
        help_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option.start();
                Toast.makeText(Main_menu.this,"Launching Help Screen",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Main_menu.this,Help.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return true;
    }

    @Override
    public void onBackPressed(){
        finish();
    }
}