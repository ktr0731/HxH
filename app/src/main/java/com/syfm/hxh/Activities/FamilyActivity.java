package com.syfm.hxh.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Spinner;

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

    private ArrayList<HashMap<String, String>> list = new ArrayList<>();
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_family);

        ButterKnife.bind(this);

        toolbar.setTitle("Family");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        setListData("車の送迎による通院は可能ですか?");
        setListData("支援するための時間は十分にありますか?");
        setListData("支援するための資金は十分にありますか?");
        setListData("支援に対する気持ちはどうですか?");

        QuestionListAdapter adapter = new QuestionListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private void setListData(String text) {
        number++;
        HashMap<String, String> data = new HashMap<>();
        data.put(Const.QUESTION_NUMBER, String.format("Q%s.", String.valueOf(number)));
        data.put(Const.QUESTION_TEXT,   text);
        list.add(data);
    }
}
