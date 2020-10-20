package com.vaibhavs.MineSweeper.UI;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vaibhavs.MineSweeper.R;
import com.vaibhavs.MineSweeper.model.Minesfield;

public class option extends AppCompatActivity {

    Minesfield mf;

    private EditText etrows;
    private EditText etcols;
    private EditText etmines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        mf = Minesfield.getInstance();
        set_dimensions();
        set_restbutton();
    }

    private void set_dimensions() {
        etrows = findViewById(R.id.input_rows);
        etcols = findViewById(R.id.input_col);
        etmines = findViewById(R.id.input_mines);

        set_inputText();

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                save_dimensions();
            }
        };
        etrows.addTextChangedListener(watcher);
        etcols.addTextChangedListener(watcher);
        etmines.addTextChangedListener(watcher);

    }

    private void set_inputText() {
        etrows.setText("" + mf.getRows());
        etcols.setText("" + mf.getCol());
        etmines.setText("" + mf.getNo_of_mines());
    }

    private void save_dimensions() {
        String rowStr = etrows.getText().toString();
        String colStr = etcols.getText().toString();
        String mineStr = etmines.getText().toString();

        String msg = null;
        try {
            int row = Integer.parseInt(rowStr);
            int col = Integer.parseInt(colStr);
            int mine = Integer.parseInt(mineStr);

            //Parameters checking
            if(row <=3 ){
                throw new IllegalArgumentException("No of rows cannot be less than 3");
            } else if (row >=51){
                throw new IllegalArgumentException("No of rows cannot be greater than 50");
            }
            if(col <= 5 ){
                throw new IllegalArgumentException("No of columns cannot be less than 3");
            } else if (col >=51){
                throw new IllegalArgumentException("No of columns cannot be greater than 50");
            }
            if(mine <=6 ){
                throw new IllegalArgumentException("Impostors cannot be less than 3");
            } else if (row >=61){
                throw new IllegalArgumentException("Impostors cannot be greater than 50");
            }
            // sets dimensions
            mf.setRows(row);
            mf.setCol(col);
            mf.setNo_of_mines(mine);
        } catch (IllegalArgumentException e){
            msg = e.getMessage();
        }
        if (msg !=null){
            Toast.makeText(option.this,msg,Toast.LENGTH_SHORT).show();
        }
    }

    private void set_restbutton() {
        Button btn_rest = findViewById(R.id.btn_timesplayed);
        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mf.setTimes_played(0);
            }
        });
    }
}