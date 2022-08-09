package com.example.scheduler.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scheduler.R;

import java.util.ArrayList;

public class DayTimeAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String operationType;
    private ArrayList<String[]> dataList;

    public DayTimeAdapter(Context context, ArrayList<String[]> dataList, int[] timeImage) {
        super();
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDataList(ArrayList<String[]> dL) {
        dataList = dL;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
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
            convertView = inflater.inflate(R.layout.outpatient_pattern,null);
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.image_one_day);
            viewHolder.quantum=(TextView) convertView.findViewById(R.id.text_am);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(pos%3==0){
            viewHolder.quantum.setText("am_Morning");
        }
        return null;
    }

    public static class ViewHolder {
        public ImageView imageView;
        private TextView quantum;//am,pm,midnight
    }
}
