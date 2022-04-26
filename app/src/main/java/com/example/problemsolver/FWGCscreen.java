package com.example.problemsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FWGCscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_w_g_cscreen);
    }

    public void StartF(View v){
        Intent intent = new Intent( this, fwgcP.class);
        startActivity(intent);
    }
}