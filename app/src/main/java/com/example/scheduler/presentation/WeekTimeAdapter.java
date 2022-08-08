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
        /****
         * STRANGE THING HERE!!!!
         */
        this.context = context;
        this.dataList = dataList;
        this.timeImage = timeImage;
        this.inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        for(int i = 0;i<7;i++){
            String day="";
            TextView num=null;
            if(i==0){
                day = monday;
                num = viewHolder.one;
            }else if(i==1){
                day = tuesday;
                num = viewHolder.two;
            }else if(i==2){
                day = wednesday;
                num = viewHolder.three;
            }else if(i==3){
                day = thursday;
                num = viewHolder.four;
            }else if(i==4){
                day = friday;
                num = viewHolder.five;
            }else if(i==5){
                day = saturday;
                num = viewHolder.six;
            }else if(i==6){
                day = sunday;
                num = viewHolder.seven;
            }

            if(day.equals("0")){
                num.setBackgroundResource(R.mipmap.btn_blockblue);
                num.setText("am");
            }else if (day.equals("1")){
                num.setBackgroundResource(R.mipmap.btn_blockbrown);
                num.setText("pm");
            }else if(day.equals("2")){
                num.setBackgroundResource(R.mipmap.btn_blocknight);
                num.setText("midnight");
            }
        }

        /*
        if(monday.equals("0")){
            viewHolder.one.setBackgroundResource(R.mipmap.btn_blockblue);
            viewHolder.one.setText("am");
        }else if (monday.equals("1")){
            viewHolder.one.setBackgroundResource(R.mipmap.btn_blockbrown);
            viewHolder.one.setText("pm");
        }else if(monday.equals("2")){
            viewHolder.one.setBackgroundResource(R.mipmap.btn_blocknight);
            viewHolder.one.setText("midnight");
        }

        if(tuesday.equals("0")){
            viewHolder.two.setBackgroundResource(R.mipmap.btn_blockblue);
            viewHolder.two.setText("am");
        }else if (tuesday.equals("1")){
            viewHolder.two.setBackgroundResource(R.mipmap.btn_blockbrown);
            viewHolder.two.setText("pm");
        }else if(tuesday.equals("2")){
            viewHolder.two.setBackgroundResource(R.mipmap.btn_blocknight);
            viewHolder.two.setText("midnight");
        }

        if(wednesday.equals("0")){
            viewHolder.three.setBackgroundResource(R.mipmap.btn_blockblue);
            viewHolder.three.setText("am");
        }else if (wednesday.equals("1")){
            viewHolder.three.setBackgroundResource(R.mipmap.btn_blockbrown);
            viewHolder.three.setText("pm");
        }else if(wednesday.equals("2")){
            viewHolder.three.setBackgroundResource(R.mipmap.btn_blocknight);
            viewHolder.three.setText("midnight");
        }

        if(thursday.equals("0")){
            viewHolder.four.setBackgroundResource(R.mipmap.btn_blockblue);
            viewHolder.four.setText("am");
        }else if (thursday.equals("1")){
            viewHolder.four.setBackgroundResource(R.mipmap.btn_blockbrown);
            viewHolder.four.setText("pm");
        }else if(thursday.equals("2")){
            viewHolder.four.setBackgroundResource(R.mipmap.btn_blocknight);
            viewHolder.four.setText("midnight");
        }

        if(friday.equals("0")){
            viewHolder.five.setBackgroundResource(R.mipmap.btn_blockblue);
            viewHolder.five.setText("am");
        }else if (friday.equals("1")){
            viewHolder.five.setBackgroundResource(R.mipmap.btn_blockbrown);
            viewHolder.five.setText("pm");
        }else if(friday.equals("2")){
            viewHolder.five.setBackgroundResource(R.mipmap.btn_blocknight);
            viewHolder.five.setText("midnight");
        }

        if(saturday.equals("0")){
            viewHolder.six.setBackgroundResource(R.mipmap.btn_blockblue);
            viewHolder.six.setText("am");
        }else if (saturday.equals("1")){
            viewHolder.six.setBackgroundResource(R.mipmap.btn_blockbrown);
            viewHolder.six.setText("pm");
        }else if(saturday.equals("2")){
            viewHolder.six.setBackgroundResource(R.mipmap.btn_blocknight);
            viewHolder.six.setText("midnight");
        }

        if(sunday.equals("0")){
            viewHolder.seven.setBackgroundResource(R.mipmap.btn_blockblue);
            viewHolder.seven.setText("am");
        }else if (sunday.equals("1")){
            viewHolder.seven.setBackgroundResource(R.mipmap.btn_blockbrown);
            viewHolder.seven.setText("pm");
        }else if(sunday.equals("2")){
            viewHolder.seven.setBackgroundResource(R.mipmap.btn_blocknight);
            viewHolder.seven.setText("midnight");
        }
         */
        return convertView;
    }

    private class ViewHolder {
        private TextView one, two, three, four, five, six, seven;
    }
}
