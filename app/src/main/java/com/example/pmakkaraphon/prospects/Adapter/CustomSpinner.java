package com.example.pmakkaraphon.prospects.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.example.pmakkaraphon.prospects.R.id.parent;

public class CustomSpinner extends BaseAdapter {
    private Context mContext;
    private List<PrenameModel> mData;
    private LayoutInflater mInflater;

    public CustomSpinner(Context context, List<PrenameModel> data) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder holder;
//
//        if (view == null) {
//            holder = new ViewHolder();
//            view = mInflater.inflate(R.layout.list_item_adapter, viewGroup, false);
//            holder.name = (TextView)view.findViewById(R.id.name);
//
//        }else {
//            holder = (ViewHolder)view.getTag();
//        }
//        holder.name.setText(mData.get(i));
        TextView name;
        view = mInflater.inflate(R.layout.list_item_adapter, viewGroup, false);
        name = (TextView) view.findViewById(R.id.name);
        name.setText(mData.get(i).getPN_NAME());

        return view;
    }

    public class ViewHolder {
//        TextView name;
    }
}