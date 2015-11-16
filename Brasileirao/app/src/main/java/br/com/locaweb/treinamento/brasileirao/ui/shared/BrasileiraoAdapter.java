package br.com.locaweb.treinamento.brasileirao.ui.shared;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public abstract class BrasileiraoAdapter<T> extends BaseAdapter {

    @RootContext protected Context ctx;

    List<T> list;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);

    public void setList(List<T> list) {
       this.list = list;
    }
}
