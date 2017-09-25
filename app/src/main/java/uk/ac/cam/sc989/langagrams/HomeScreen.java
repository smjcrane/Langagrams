package uk.ac.cam.sc989.langagrams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {
    private Button buttonPlay;
    private Button buttonLevelSelect;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //setup the automatic play button
        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO get the id or something of the last level we were playing
                Intent playLevel = new Intent(HomeScreen.this, PlayLevelActivity.class);
                startActivity(playLevel);
            }
        });

        //setup the level select button
        buttonLevelSelect = (Button) findViewById(R.id.buttonLevelSelect);
        buttonLevelSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectLevel = new Intent(HomeScreen.this, LevelSelectActivity.class);
                startActivity(selectLevel);
            }
        });

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.title);
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
