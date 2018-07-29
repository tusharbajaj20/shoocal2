package com.example.dell.lasttry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 6/25/2017.
 */

public class custom extends BaseAdapter {
    ArrayList n=new ArrayList();
    ArrayList p=new ArrayList();
    ArrayList s=new ArrayList();

    Context c=null;
    LayoutInflater inflater=null;

    public custom(MainActivity mainActivity) {
        n=mainActivity.n;
        p=mainActivity.p;
        s=mainActivity.s;
        c=mainActivity;
        inflater=(LayoutInflater.from(c));

    }

    @Override
    public int getCount() {
        return n.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.design,null);
        TextView txt=(TextView)convertView.findViewById(R.id.editText4);
        txt.setText(n.get(position)+"");
        TextView txt2=(TextView)convertView.findViewById(R.id.editText5);
        txt2.setText(p.get(position)+"");
        TextView txt3=(TextView)convertView.findViewById(R.id.editText7);
        txt3.setText(s.get(position)+"");
        return convertView;
    }
}
