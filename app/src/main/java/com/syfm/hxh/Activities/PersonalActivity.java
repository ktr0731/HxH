package com.syfm.hxh.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.syfm.hxh.Adapter.QuestionListAdapter;
import com.syfm.hxh.R;
import com.syfm.hxh.Utils.Const;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import de.greenrobot.event.EventBus;

/**
 * Created by lycoris on 2016/03/26.
 */
public class PersonalActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.listview_personal)
    ListView listView;

    @Bind(R.id.button_next)
    Button button;

    @OnClick(R.id.button_next)
    public void onClickNext() {
        Intent i = new Intent(this, FamilyActivity.class);
        startActivityForResult(i, 0);
    }

    private ArrayList<HashMap<String, String>> list = new ArrayList<>();
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_personal);

        ButterKnife.bind(this);

        toolbar.setTitle("患者個人");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        setListData("スイーツが好きですね?");               // 生理的
        setListData("家族に介護の負担を掛けたくないですね?"); // 安全
        setListData("友達とサッカーをする時間が大事ですね?"); // 社会的
        setListData("サッカーでモテモテになりたいですね?");   // 尊重
        setListData("サッカーでゴールを決めてみたいですね?"); // 自己実現
        setListData("サッカーのために治療をがんばれますね?"); // その他

        QuestionListAdapter adapter = new QuestionListAdapter(this, list, list.size());
        listView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void setListData(String text) {
        number++;
        HashMap<String, String> data = new HashMap<>();
        data.put(Const.QUESTION_NUMBER, String.format("Q%s.", String.valueOf(number)));
        data.put(Const.QUESTION_TEXT, text);
        list.add(data);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 0:
                finish();
                break;
        }
    }

    public void onEvent(Boolean isValid) {
        if (isValid) {
            button.setVisibility(View.VISIBLE);
        }
    }
}
