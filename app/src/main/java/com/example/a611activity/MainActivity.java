package com.example.a611activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String SAVED_KEY = "text_for_save";
    TextView textView;
    private String savedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "onCreate");
        textView = findViewById(R.id.textView);
        if (savedInstanceState == null) {
            textView.setText("\n" + "ОnClick");
        }
        else {
            final String savedText = savedInstanceState.getString(SAVED_KEY);
            textView.append(savedText + "\n" + "ОnClick");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
       Log.d("Lifecycle", "OnStart");;
        textView.append("\n" + "ОnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "OnResume");;
        textView.append("\n" + "ОnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "OnPause");;
        textView.append("\n" + "ОnPaused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "OnStop");;
        textView.append("\n" + "ОnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "OnDestroy");;
        textView.append("\n" + "ОnDestroy");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("LifeCycle", "onKeyDown" );
        textView.append("\n" + "onKeyDown");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.d("LifeCycle", "onKeyLongPress" );
        textView.append("\n" + "onKeyLongPress");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        Log.d("LifeCycle", "onBackPressed" );
        textView.append("\n" + "onBackPressed");
        super.onBackPressed();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("LifeCycle", "onSaveInstanceState" );
        textView.append("\n" + "onSaveInstanceState");
        String textForSave = textView.getText().toString();
        outState.putString(SAVED_KEY, textForSave);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("LifeCycle", "onRestoreInstanceState" );
        super.onRestoreInstanceState(savedInstanceState);
        savedText = savedInstanceState.getString(SAVED_KEY);
        textView.append("\n" + "onRestoreInstanceState");
    }
}
