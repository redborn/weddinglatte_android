package org.redborn.weddinglatte.android.view.main.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.redborn.weddinglatte.R;
import org.redborn.weddinglatte.android.view.BusinessDetailActivity;

import java.util.ArrayList;

/**
 * Created by jjj on 2016-05-17.
 */
public class BusinessAdapter extends BaseAdapter  {
    Context con;
    LayoutInflater inflacter;
    ArrayList<BusinessItem> arD;
    int layout;

    public BusinessAdapter(Context context, int alayout, ArrayList<BusinessItem> aarD) {
        con = context;
        inflacter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        arD = aarD;
        layout = alayout;
    }

    // 어댑터에 몇 개의 항목이 있는지 조사
    @Override
    public int getCount() {
        return arD.size();
    }

    // position 위치의 항목 Name 반환
    @Override
    public Object getItem(int position) {
        return arD.get(position).content;
    }

    // position 위치의 항목 ID 반환
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 각 항목의 뷰 생성 후 반환
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflacter.inflate(layout, parent, false);
        }
        /*
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView1);
        img.setImageResource(arD.get(position).icon);
        */

        LinearLayout img = (LinearLayout) convertView.findViewById(R.id.business_background_img);
        img.setBackgroundResource(arD.get(position).icon);

        TextView txt = (TextView) convertView.findViewById(R.id.textView1);
        txt.setTextColor(Color.WHITE);
        txt.setText(arD.get(position).content);

        img.setOnClickListener(new LinearLayout.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(BusinessAdapter.this, BusinessDetailActivity.class);
                //startActivity(intent);
                Intent intent = new Intent(con, BusinessDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                con.startActivity(intent);
            }
        });
        return convertView;
    }
}
