package com.rybakov.exam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomVote extends ArrayAdapter<String> {

    Activity context;
    String[] ids;
    String[] names;
    String[] votes;
    Integer[] photos;


    public CustomVote(Activity context, int resource, String[] i,String[] n, String[] v, Integer[] p) {
        super(context, R.layout.mu_row,i);

        this.context=context;
        ids=i;
        names=n;
        votes=v;
        photos=p;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.mu_row, null,true);
        TextView tvID = (TextView)v.findViewById(R.id.start_id);
        TextView tvName = (TextView)v.findViewById(R.id.start_name);
        TextView tvVote = (TextView)v.findViewById(R.id.start_vote);
        ImageView iv = (ImageView)v.findViewById(R.id.start_photo);

        tvID.setText(ids[position]);
        tvName.setText(names[position]);
        tvVote.setText(votes[position]);
        iv.setImageResource(photos[position]);

        return v;
    }
}
