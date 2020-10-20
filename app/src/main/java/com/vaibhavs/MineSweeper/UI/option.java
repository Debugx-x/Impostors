package com.vaibhavs.MineSweeper.UI;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    private void save_dimensions() {
        mf.setRows(Integer.parseInt(etrows.getText().toString()));
        mf.setCol(Integer.parseInt(etcols.getText().toString()));
        mf.setNo_of_mines(Integer.parseInt(etmines.getText().toString()));
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