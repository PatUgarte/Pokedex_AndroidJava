package com.patugarte.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.patugarte.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.primerContenedorDeFragments, recyclerViewFragment).commit();
    }
}
