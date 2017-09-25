package uk.ac.cam.sc989.langagrams;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PlayLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_level);

        Intent caller = getIntent();
        String letters = caller.getStringExtra("letters");

        TextView textLetters = (TextView) findViewById(R.id.letters);
        textLetters.setText(letters);
    }

}
