package br.com.locaweb.treinamento.adaptertest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean
public class AACustomAdapter extends BaseAdapter {

    @RootContext
    protected Context ctx;

    private List<String> list;

    @Override
    public int getCount() {
        return getList().size();
    }

    @Override
    public Object getItem(int position) {
        return getList().get(position);
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


    public List<String> getList() {
        if(list == null) list = new ArrayList<>();
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
