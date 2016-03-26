package com.syfm.hxh.Activities;

import android.content.Intent;
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
import butterknife.OnClick;

/**
 * Created by lycoris on 2016/03/26.
 */
public class PersonalActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.listview_personal)
    ListView listView;
    @OnClick(R.id.button_next)
    public void onClickNext() {
        Intent i = new Intent(this, FamilyActivity.class);
        startActivity(i);
    }

    private ArrayList<HashMap<String, String>> list = new ArrayList<>();
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_personal);

        ButterKnife.bind(this);

        toolbar.setTitle("Personal");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        setListData("深夜に電気を消してテレビを見るのが好きだ");
        setListData("人混みの中にいるのが好きだ");
        setListData("友達と釣りに行くのが好きだ");

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
