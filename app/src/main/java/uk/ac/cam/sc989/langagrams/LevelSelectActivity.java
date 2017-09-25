package uk.ac.cam.sc989.langagrams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class LevelSelectActivity extends AppCompatActivity {
    private ListView levelList;
    Puzzle test = new Puzzle("helloworld");
    ArrayList levels = new ArrayList(Arrays.asList(test, test, test));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        levelList = (ListView) findViewById(R.id.listOfLevels);

        LevelListAdapter myAdapter = new LevelListAdapter(this, R.layout.list_item_level, levels);
        levelList.setAdapter(myAdapter);

        levelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long row) {
                Intent playLevel = new Intent(LevelSelectActivity.this, PlayLevelActivity.class);
                playLevel.putExtra("letters", levels.get(position).toString());
                startActivity(playLevel);
                finish();
            }
        });
    }
}
