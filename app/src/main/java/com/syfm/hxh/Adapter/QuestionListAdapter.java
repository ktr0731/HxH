package com.syfm.hxh.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.syfm.hxh.R;
import com.syfm.hxh.Utils.Const;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import de.greenrobot.event.EventBus;

/**
 * Created by lycoris on 2016/03/26.
 */
public class QuestionListAdapter extends BaseAdapter {

    Context context;
    ArrayList<HashMap<String, String>> list;
    LayoutInflater inflater;

    public QuestionListAdapter(Context context, ArrayList<HashMap<String, String>> list, int count) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.max_count = count;
    }

    private int count;
    private int max_count;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;

        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.row_question, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (count > 0 && position == 0) {
                    // -- 選択してください --
                    count--;
                } else {
                    count++;
                }

                if(isValid()) {
                    EventBus.getDefault().post(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        holder.tv_question_number.setText(list.get(position).get(Const.QUESTION_NUMBER));
        holder.tv_question_text.setText(list.get(position).get(Const.QUESTION_TEXT));

        return view;
    }

    public static class ViewHolder {

        @Bind(R.id.tv_question_number)
        TextView tv_question_number;
        @Bind(R.id.tv_question_text)
        TextView tv_question_text;
        @Bind(R.id.spinner_selection)
        Spinner spinner;


        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public boolean isValid() {
        if (this.max_count == count) {
            return true;
        }

        return false;
    }
}
