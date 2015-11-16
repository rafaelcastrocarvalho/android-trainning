package br.com.locaweb.treinamento.adaptertest;

import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.array)
public class ArrayAdapterFragment extends Fragment {

    @ViewById EditText editItem;

    @ViewById ListView myList;

    @ViewById TextView empty;

    @Click(R.id.btn_add)
    public void addItem() {
        ArrayAdapter adapter = (ArrayAdapter) myList.getAdapter();

        String item = editItem.getText().toString();
        if(item != null && !"".equals(item)) adapter.add(item);

        editItem.getText().clear();
    }

    @AfterViews
    protected void init() {
        myList.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1));
        myList.setEmptyView(empty);
    }
}
