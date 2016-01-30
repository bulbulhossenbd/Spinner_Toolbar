package com.example.appsd.spinner;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeAsUpIndicator(R.drawable.menu2);
        actionBar.setDisplayHomeAsUpEnabled(true);

        final Spinner mSpinner = (Spinner) findViewById(R.id.spinner_rss);

        String[] items = getResources().getStringArray(R.array.spinner_rss_items);
        final List<String> spinnerItems = new ArrayList<String>();

        for (int i = 0; i < items.length; i++) {
            spinnerItems.add(items[i]);
        }

        SpinnerAdapter adapter = new SpinnerAdapter(actionBar.getThemedContext(), spinnerItems);
        mSpinner.setAdapter(adapter);


        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                System.err.println("**************" + position);

                switch (position) {
                    case 0:
                        Intent i = new Intent();
                        i.setClass(MainActivity.this, Blank.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent ir = new Intent();
                        ir.setClass(MainActivity.this, Blank.class);
                        startActivity(ir);
                        break;
                    case 2:
                        Intent ic = new Intent();
                        ic.setClass(MainActivity.this, Blank.class);
                        startActivity(ic);
                        break;
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            mSpinner.setDropDownVerticalOffset(-116);
        }
    }
}