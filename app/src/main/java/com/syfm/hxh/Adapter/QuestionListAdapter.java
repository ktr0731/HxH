package com.syfm.hxh.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by lycoris on 2016/03/26.
 */
public class QuestionListAdapter extends BaseAdapter {

    Context context;
    ArrayList<HashMap<String, String>> list;
    LayoutInflater inflater;

    public QuestionListAdapter(Context context, ArrayList<HashMap<String, String>> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

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

        holder.tv_question_number.setText(list.get(position).get(Const.QUESTION_NUMBER));
        holder.tv_question_text.setText(list.get(position).get(Const.QUESTION_TEXT));

        return view;
    }

    public static class ViewHolder {

        @Bind(R.id.tv_question_number)
        TextView tv_question_number;
        @Bind(R.id.tv_question_text)
        TextView tv_question_text;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
