package uk.ac.cam.sc989.langagrams;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 25/09/2017.
 */

public class LevelListAdapter extends ArrayAdapter {
    private Context mContext;
    private List<Puzzle> infoSet;

    public LevelListAdapter(Context context, int resource, List<Puzzle> items) {
        super(context, resource, items);
        this.mContext = context;
        this.infoSet = (ArrayList<Puzzle>) items;
    }


    @Override
    public View getView(final int position, View v, ViewGroup parent) {

        Log.d("LISTADAPT", "getting View");
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_item_level, null);
        }

        TextView levelName = (TextView) v.findViewById(R.id.levelName);
        levelName.setText("Level " + Integer.toString(position));

        ImageView englishFlag = (ImageView) v.findViewById(R.id.flagEnglish);
        englishFlag.setImageResource(infoSet.get(position).completed(Dictionary.ENGLISH) ? R.drawable.union_flag : R.drawable.union_flag_faded);

        ImageView dummyFlag = (ImageView) v.findViewById(R.id.flagDummy);
        dummyFlag.setImageResource(infoSet.get(position).completed(Dictionary.DUMMY_TEST) ? R.drawable.dummy : R.drawable.dummy_faded);

        return v;
    }

}
