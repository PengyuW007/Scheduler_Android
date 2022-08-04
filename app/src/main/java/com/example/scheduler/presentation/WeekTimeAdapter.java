package com.example.scheduler.presentation;

import android.app.Activity;
import android.content.*;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeekTimeAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String[]>dataList;
    private int[]timeImage;

    public WeekTimeAdapter(Context context,ArrayList<String[]>dataList,int[]timeImage){
        this.context = context;
        this.dataList = dataList;
        this.timeImage = timeImage;
    }//end WeekTimeAdapter constructor

    public void setDataList(ArrayList<String[]>dL){
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
        ViewHolder viewHolder;

        if(convertView==null){
            viewHolder = new ViewHolder();
        }
        return null;
    }

    private class ViewHolder{
        private TextView monday,tuesday,wednesday,thursday,friday,saturday,sunday;
    }
}
