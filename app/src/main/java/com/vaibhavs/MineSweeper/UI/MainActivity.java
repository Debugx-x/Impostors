package com.vaibhavs.MineSweeper.UI;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.vaibhavs.MineSweeper.R;

// using Glide gif decoder to play the main screen gif
// using daimajia android animations
// https://github.com/daimajia/AndroidViewAnimations

/**
 * The Welcome Splash Screen of the game that play different animations
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animate();
        skip_animation();
        ShowGif();
    }
    public void ShowGif(){
        ImageView iv = findViewById(R.id.img_welcome);
        Glide.with(this).load(R.drawable.main).into(iv);
    }

    private void skip_animation() {
        Button skip = findViewById(R.id.btn_skip);
        final MediaPlayer option = MediaPlayer.create(this,R.raw.option_btn);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option.start();
                Intent i = new Intent(MainActivity.this,Main_menu.class);
                startActivity(i);
            }
        });
    }

    private void animate() {

        TextView titletxt = findViewById(R.id.txt_title);
        YoYo.with(Techniques.Tada)
                .duration(2000)
                .repeat(0)
                .playOn(titletxt);
        ImageView titleimg = findViewById(R.id.img_welcome);
        YoYo.with(Techniques.FadeIn)
                .duration(4000)
                .repeat(0)
                .playOn(titleimg);
        TextView bytitle = findViewById(R.id.txt_byline);
        YoYo.with(Techniques.ZoomIn)
                .duration(2000)
                .repeat(0)
                .playOn(bytitle);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,Main_menu.class);
                startActivity(i);
            }
        },4000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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