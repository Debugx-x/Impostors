package com.vaibhavs.MineSweeper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
// using daimajia android animations
// https://github.com/daimajia/AndroidViewAnimations
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.vaibhavs.MineSweeper.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animate();
        skip_animation();
    }

    private void skip_animation() {
        Button skip = findViewById(R.id.btn_skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main_menu.class);
                startActivity(i);
            }
        });
    }

    private void animate() {

        TextView titletxt = findViewById(R.id.txt_title);
        YoYo.with(Techniques.Tada)
                .duration(2500)
                .repeat(0)
                .playOn(titletxt);
        ImageView titleimg = findViewById(R.id.img_welcome);
        YoYo.with(Techniques.FadeIn)
                .duration(5000)
                .repeat(0)
                .playOn(titleimg);
        TextView bytitle = findViewById(R.id.txt_byline);
        YoYo.with(Techniques.ZoomIn)
                .duration(2500)
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
                finish();
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}