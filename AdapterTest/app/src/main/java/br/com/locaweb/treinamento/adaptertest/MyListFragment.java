package br.com.locaweb.treinamento.adaptertest;

import android.support.v4.app.Fragment;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EFragment(R.layout.list)
public class MyListFragment extends Fragment {

    @FragmentArg
    int qtdListItems;

    @ViewById
    ListView myList;

    SimpleAdapter adapter;

    private List<Map<String, String>> data;

    @AfterViews
    public void init() {
        List<Map<String, String>> data = getData();
        int resource = R.layout.my_list_item;
        String[] from = {"name", "qtd"};
        int[] to = {R.id.txt_1, R.id.txt_2};
        adapter = new SimpleAdapter(getActivity(), data, resource, from, to);
        myList.setAdapter(adapter);
    }

    public List<Map<String, String>> getData() {
        List<Map<String, String>> list = new ArrayList<>(qtdListItems);
        for(int i = 0; i < qtdListItems; i++) {
           list.add(createItem(i));
        }
        return list;
    }

    private Map<String, String> createItem(int i) {
        Map<String, String> map = new HashMap<>();
        map.put("name", getString(R.string.list_item_x, i));
        map.put("qtd", "" + i);
        return map;
    }
}
