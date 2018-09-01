package com.example.julio.energiainteligente.ui.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.julio.energiainteligente.R;

public class AlertMessage {

    private static AlertDialog.Builder dialog;

    public static void showMessage(Context context, String message, String title) {
        dialog = new AlertDialog.Builder(context, R.style.Sphinx);

        dialog.setTitle(title);

        dialog.setMessage(message);

        dialog.setCancelable(false);

        dialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        dialog.create();
        dialog.show();
    }
}
