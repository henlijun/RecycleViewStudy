package com.lj.diffmodule.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lj.diffmodule.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickEvent(View view){
        int rid = view.getId();
        Intent intent = null;
        switch (rid){
            case R.id.button2:
                intent = new Intent(this, RecycleActivity.class);
                break;
            case R.id.button3:
                intent = new Intent(this, RecycleDiffActivity.class);
                break;
            case R.id.button4:
                intent = new Intent(this, RecycleAsyncDiffActivity.class);
                break;
        }

        if(intent != null)
            startActivity(intent);
    }
}