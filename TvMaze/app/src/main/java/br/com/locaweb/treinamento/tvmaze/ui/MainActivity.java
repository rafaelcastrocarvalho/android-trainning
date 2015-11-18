package br.com.locaweb.treinamento.tvmaze.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Arrays;

import br.com.locaweb.treinamento.tvmaze.R;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    @ViewById
    ListView list;

    ArrayAdapter<Integer> adapter;

    @AfterViews
    protected void init() {
        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1);
        for(int i = 0; i <= 50; ++i) {
            adapter.add(i);
        }
        list.setAdapter(adapter);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        int last = adapter.getItem(adapter.getCount() - 1);
        for(int i = last; i < last + 10; ++i) {
            adapter.add(i);
        }
        adapter.notifyDataSetChanged();
    }
}
