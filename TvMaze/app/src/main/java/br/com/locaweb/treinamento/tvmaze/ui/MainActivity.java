package br.com.locaweb.treinamento.tvmaze.ui;

import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.Collection;

import br.com.locaweb.treinamento.tvmaze.R;
import br.com.locaweb.treinamento.tvmaze.infra.ShowRepositoryImpl;
import br.com.locaweb.treinamento.tvmaze.model.Show;
import br.com.locaweb.treinamento.tvmaze.model.ShowRepository;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    @Bean(ShowRepositoryImpl.class)
    ShowRepository showRepository;

    @ViewById(R.id.endless_list)
    ListView endlessList;

    ArrayAdapter<Show> adapter;
    private Collection<Show> shows;

    @AfterViews
    protected void init() {
        adapter = new ArrayAdapter<Show>(this, android.R.layout.simple_list_item_1);
        endlessList.setAdapter(adapter);
        endlessList.setOnScrollListener(this);
        getShows();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Toast.makeText(this, "firstVisibleItem:" + firstVisibleItem + " visibleItemCount:" + visibleItemCount + " totalItemCount: " + totalItemCount, Toast.LENGTH_SHORT).show();
//        getShows();
    }

    @Background
    public void getShows() {
        int page = 0;
        if(adapter.getCount() > 0 ) page = adapter.getCount() / 250;

        try {
            shows = showRepository.listShows(page);
            appendOnAdapter();
        } catch (Exception e) {

        }
    }

    @UiThread
    protected void appendOnAdapter() {
        adapter.addAll(shows);
        adapter.notifyDataSetChanged();
    }
}
