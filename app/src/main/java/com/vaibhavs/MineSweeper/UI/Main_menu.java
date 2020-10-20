package com.vaibhavs.MineSweeper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vaibhavs.MineSweeper.R;
import com.vaibhavs.MineSweeper.model.Minesfield;

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
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increment no of games played
                mf.setTimes_played(mf.getTimes_played()+1);
                Toast.makeText(Main_menu.this,"Launching Game Screen",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Main_menu.this,Help.class);
                startActivity(i);
            }
        });
        Button option_btn = findViewById(R.id.btn_options);
        option_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main_menu.this,"Launching options Screen",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Main_menu.this,option.class);
                startActivity(i);
            }
        });
        Button help_btn = findViewById(R.id.btn_help);
        help_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()) {
            case android.R.id.home:
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}