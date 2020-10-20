package com.vaibhavs.MineSweeper.UI;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vaibhavs.MineSweeper.R;
import com.vaibhavs.MineSweeper.model.Minesfield;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class game extends AppCompatActivity {


    Minesfield mf;

    private int mines_found = 0;
    private int Scan_no = 0;
    private int rows = mf.getRows();
    private int col = mf.getCol();
    Button[][] buttons = new Button[rows][col];
    private List<Button> btns = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        
        mf = Minesfield.getInstance();
        set_initialtexts();
        populateButtons();
        set_mines(buttons);
    }

    private void set_mines(Button[][] buttons) {
        Random rand = new Random();
        int r,c;
        for (int i = 0; i < mf.getNo_of_mines();){
            r = rand.nextInt(mf.getRows());
            c = rand.nextInt(mf.getCol());
            if (buttons[r][c].getText() != "mine"){
                buttons[r][c].setText("mine");
                buttons[r][c].setTextColor(0xff0000);
                i++;
            }
        }
    }

    private void set_initialtexts() {
        TextView played_times = findViewById(R.id.txt_timesplayed);
        played_times.setText("Times Played: " + mf.getTimes_played());
        TextView Scans = findViewById(R.id.txt_scans);
        Scans.setText("# Scans used: " + Scan_no);
        TextView Mines = findViewById(R.id.txt_minesno);
        Mines.setText("Found 0 of " + mf.getNo_of_mines()+" Mines");
    }

    private void populateButtons() {
        TableLayout table = findViewById(R.id.buttontable);

        for (int row = 0; row < mf.getRows(); row++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);

            for (int col = 0; col < mf.getCol(); col++) {
                final int FINAL_COL = mf.getCol();
                final int FINAL_ROW = mf.getRows();

                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                // Make text not clip on small buttons
                button.setPadding(0, 0, 0, 0);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        set_onClickScans();
                        gridButtonClicked(FINAL_ROW,FINAL_COL);
                    }
                });

                tableRow.addView(button);
                buttons[row][col] = button;
            }
        }
    }

    private void set_onClickScans() {
        Scan_no++;
        TextView Scans = findViewById(R.id.txt_scans);
        Scans.setText("# Scans used: " + Scan_no);
    }

    private void gridButtonClicked(int row, int col) {
        Button button = buttons[row][col];

        // Lock Button Sizes:
        lockButtonSizes();

        int newWidth = button.getWidth();
        int newHeight = button.getHeight();
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable._citypng_com_hd_red_among_us_character_with_knife_on_hand_png___1167x1590);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
        Resources resource = getResources();
        button.setBackground(new BitmapDrawable(resource, scaledBitmap));

        // Change text on button:
        button.setText("");
    }

    private void lockButtonSizes() {
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < col; c++){
                Button button = buttons[r][c];
                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }

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