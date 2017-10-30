package com.axlecho.learn.sharedelementtransition;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView hellowordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hellowordTextView = (TextView) findViewById(R.id.hello_world_textview);
        hellowordTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String transition_name = this.getResources().getString(R.string.transition_name);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, hellowordTextView, transition_name);

        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
