package com.codealpha.fitnesstracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintSet;

public class ToastMaker {
    Context context;
    String text;
    public ToastMaker(Context c1){
        this.context=c1;
    }
    LayoutInflater li=LayoutInflater.from(context);
    View v=li.inflate(R.layout.toast,null);
    public void makeToast(String text){
        this.text=text;
        Toast t=new Toast(context);
        TextView txt=v.findViewById(R.id.toast_text);
        txt.setText(text);
        t.setDuration(Toast.LENGTH_SHORT);
        t.show();

    }
}
