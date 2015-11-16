package br.com.locaweb.treinamento.adaptertest;

import android.support.v4.app.Fragment;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.array)
public class AABaseAdapterFragment extends Fragment {

    @ViewById
    EditText editItem;

    @ViewById ListView myList;

    @ViewById
    TextView empty;

    @Bean
    AACustomAdapter adapter;

    @AfterViews
    public void init() {
        myList.setAdapter(new CustomAdapter(getContext(), new ArrayList<String>()));
        myList.setEmptyView(empty);
    }

    @Click(R.id.btn_add)
    public void addItem() {
        String item = editItem.getText().toString();
        if(item != null && !"".equals(item)) adapter.add(item);

        editItem.getText().clear();
    }
}
