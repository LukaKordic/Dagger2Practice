package com.lukakordic.dagger2example.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lukakordic.dagger2example.R;
import com.lukakordic.dagger2example.data.DataManager;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
