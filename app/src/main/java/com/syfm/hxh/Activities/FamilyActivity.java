package com.syfm.hxh.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.syfm.hxh.Adapter.QuestionListAdapter;
import com.syfm.hxh.R;
import com.syfm.hxh.Utils.Const;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Slme on 2016/03/27.
 */
public class FamilyActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.listview_family)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_family);

        ButterKnife.bind(this);

        toolbar.setTitle("Personal");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        // For debug

        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> data = new HashMap<>();
            data.put(Const.QUESTION_NUMBER, String.format("Q%s.", String.valueOf(i+1)));
            data.put(Const.QUESTION_TEXT,   "HogeHoge");
            list.add(data);
        }

        QuestionListAdapter adapter = new QuestionListAdapter(this, list);
        listView.setAdapter(adapter);
    }
}
