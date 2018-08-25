package com.example.julio.energiainteligente.ui.util;

import android.content.Context;
import android.os.Handler;

import com.example.julio.energiainteligente.R;

public class LoadingOverlay {
    public static LoadingOverlay instance;
    private TransparentProgressDialog mTransparentProgressDialog;
    private Handler mHandler;
    private Runnable mRunnable;
    private static Context mContext;

    public static LoadingOverlay getInstance(Context c){
        mContext = c;
        if (instance==null){
            instance = new LoadingOverlay();
        }
        return instance;
    }

    public void showLoading(){
        mHandler = new Handler();
        mTransparentProgressDialog = new TransparentProgressDialog(mContext, R.drawable.loading);
        mRunnable =new Runnable() {
            @Override
            public void run() {
                if (mTransparentProgressDialog.isShowing()) {
                    mTransparentProgressDialog.dismiss();
                }
            }
        };
        mTransparentProgressDialog.show();
    }

    public void hideLoading(){
        mHandler.removeCallbacks(mRunnable);
        try {
            if ((mTransparentProgressDialog != null) && mTransparentProgressDialog.isShowing()) {
                mTransparentProgressDialog.dismiss();
            }
        } catch (final IllegalArgumentException e) {
            // Handle or log or ignore
        } catch (final Exception e) {
            // Handle or log or ignore
        } finally {
            mTransparentProgressDialog = null;
        }
    }
}
