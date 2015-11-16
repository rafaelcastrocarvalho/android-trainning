package br.com.locaweb.treinamento.adaptertest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context ctx;
    private List<String> list;

    public CustomAdapter(Context ctx, List<String> list) {
        this.ctx = ctx;
        this.list = list;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = View.inflate(ctx, android.R.layout.simple_list_item_1, null);
        }

        ((TextView) convertView).setText(getItem(position).toString());

        return  convertView;
    }

    public void add(String item) {
       list.add(item);
       this.notifyDataSetChanged();
    }
}
