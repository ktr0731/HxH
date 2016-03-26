package com.syfm.hxh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lycoris on 2016/03/26.
 */
public class PersonalActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        toolbar.setTitle("Personal");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }


}
