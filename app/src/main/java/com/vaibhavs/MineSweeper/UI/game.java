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

import java.util.Random;

public class game extends AppCompatActivity {


    Minesfield mf;

    private int rows;
    private int cols;
    private int mines_found = 0;
    private int Scan_no = 0;
    Button[][] buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mf = Minesfield.getInstance();

        extractData();
        set_initialtexts();
    }

    private void set_mines(Button[][] btn) {
        Random rand = new Random();
        int r,c;
        for (int i = 0; i < mf.getNo_of_mines();){
            r = rand.nextInt(rows);
            c = rand.nextInt(cols);
            if (btn[r][c].getText() != "mine"){
                btn[r][c].setText("mine");
                btn[r][c].setTextColor(0xffffff);
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

        for (int row = 0; row < rows; row++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);

            for (int col = 0; col < cols; col++) {
                final int FINAL_COL = col;
                final int FINAL_ROW = row;

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
        if (button.getText() == "mine") {

            // increases no of mines found and sets text
            set_foundmines();
            // Lock Button Sizes:
            lockButtonSizes();

            int newWidth = button.getWidth();
            int newHeight = button.getHeight();
            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.impostor);
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource, scaledBitmap));
        }
        getMines(row,col);
        winScreen();
    }

    private void winScreen() {
        if(mines_found == mf.getNo_of_mines()){

        }
    }

    private void getMines(int row,int col) {
        int mine = 0;
        Button btn = buttons[row][col];
        if(Scan_no <= rows*cols){
            for (int c = 0;c < cols; c++){
                if (buttons[row][c].getText() == "mine"){
                    mine++;
                }
            }
            for (int r = 0; r < rows;r++ ){
                if(buttons[r][col].getText() == "mine"){
                    mine++;
                }
            }
            btn.setText("" + mine);
        }
    }

    private void set_foundmines() {
        mines_found++;
        TextView Mines = findViewById(R.id.txt_minesno);
        Mines.setText("Found " + mines_found + " of " + mf.getNo_of_mines()+" Mines");
    }

    private void lockButtonSizes() {
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
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

    private void extractData() {
        if(mf.getTimes_played() == 1){
            rows = 4;
            cols = 6;
            mf.setNo_of_mines(6);
            mf.setRows(rows);
            mf.setCol(cols);
        }else{
            rows = mf.getRows();
            cols = mf.getCol();
        }
        buttons = new Button[rows][cols];
        populateButtons();
        set_mines(buttons);
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
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}