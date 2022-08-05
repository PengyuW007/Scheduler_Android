package com.example.scheduler.presentation;

import android.app.Activity;
import android.content.*;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.scheduler.R;

import java.util.ArrayList;

public class WeekTimeAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String[]> dataList;
    private int[] timeImage;

    public WeekTimeAdapter(Context context, ArrayList<String[]> dataList, int[] timeImage) {
        this.context = context;
        this.dataList = dataList;
        this.timeImage = timeImage;
    }//end WeekTimeAdapter constructor

    public void setDataList(ArrayList<String[]> dL) {
        dataList = dL;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_schedule, null);
            viewHolder.one = (TextView) convertView.findViewById(R.id.one_day);
            viewHolder.two = (TextView) convertView.findViewById(R.id.two_day);
            viewHolder.three = (TextView) convertView.findViewById(R.id.three_day);
            viewHolder.four = (TextView) convertView.findViewById(R.id.four_day);
            viewHolder.five = (TextView) convertView.findViewById(R.id.five_day);
            viewHolder.six = (TextView) convertView.findViewById(R.id.six_day);
            viewHolder.seven = (TextView) convertView.findViewById(R.id.seven_day);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String monday = dataList.get(pos)[0];
        String tuesday = dataList.get(pos)[1];
        String wednesday = dataList.get(pos)[2];
        String thursday = dataList.get(pos)[3];
        String friday = dataList.get(pos)[4];
        String saturday = dataList.get(pos)[5];
        String sunday = dataList.get(pos)[6];

        if(monday.equals("0")){
            //viewHolder.one.setBackgroundResource(R.mipmap.);
        }
        return null;
    }

    private class ViewHolder {
        private TextView one, two, three, four, five, six, seven;
    }
}
