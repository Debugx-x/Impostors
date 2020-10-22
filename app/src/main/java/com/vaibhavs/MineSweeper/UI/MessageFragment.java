package com.vaibhavs.MineSweeper.UI;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.vaibhavs.MineSweeper.R;

/**
 * Player Victory Screen
 */
public class MessageFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Create the view to show
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.win_message, null);

        // Create a button Listener
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().finish();

            }
        };
        // Build the alert dialog
        return new AlertDialog.Builder(getActivity())
                .setTitle("CONGRATULATIONS")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .create();
    }
}