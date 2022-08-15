package com.example.scheduler.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scheduler.R;
import com.example.scheduler.objects.Shift;

import java.util.ArrayList;

/***
 * Class: DayTimeAdapter
 *
 * Purpose: Each unit/cell pattern in the gridview
 *
 *
 */
public class DayTimeAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Shift> dataList;

    public DayTimeAdapter(Context context, ArrayList<Shift> dataList) {
        super();
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.dataList = dataList;
    }

    public void setDataList(ArrayList<Shift> dL) {
        dataList = dL;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int pos) {
        return dataList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.outpatient_pattern, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image_one_day);
            viewHolder.quantum = (TextView) convertView.findViewById(R.id.text_am);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (pos % 3 == 0) {
            if (dataList.get(pos).isChecked()) {
                viewHolder.imageView.setImageResource(R.mipmap.ico_am);
            } else {
                viewHolder.imageView.setImageResource(R.mipmap.ico_seltime);
            }
        } else if (pos % 3 == 1) {
            if (dataList.get(pos).isChecked()) {
                viewHolder.imageView.setImageResource(R.mipmap.ico_pm);
            } else {
                viewHolder.imageView.setImageResource(R.mipmap.ico_seltime);
            }
        } else if (pos % 3 == 2) {
            if (dataList.get(pos).isChecked()) {
                viewHolder.imageView.setImageResource(R.mipmap.ico_night);
            } else {
                viewHolder.imageView.setImageResource(R.mipmap.ico_seltime);
            }
        }


        return convertView;
    }

    public static class ViewHolder {
        public ImageView imageView;
        private TextView quantum;//am,pm,midnight
    }
}
