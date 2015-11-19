package br.com.locaweb.treinamento.tvmaze.ui.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.Collection;

import br.com.locaweb.treinamento.tvmaze.R;
import br.com.locaweb.treinamento.tvmaze.infra.ShowRepositoryImpl;
import br.com.locaweb.treinamento.tvmaze.model.Show;
import br.com.locaweb.treinamento.tvmaze.model.ShowRepository;

@EActivity(R.layout.activity_home)
@OptionsMenu(R.menu.main)
public class HomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener  {

    private Collection<Show> shows;

    HomePagerAdapter adapter;

    @Bean(value = ShowRepositoryImpl.class)
    ShowRepository showRepository;

    @ViewById
    ListView list;

    @Extra
    Show show;

    @ViewById
    TabLayout tabs;

    @ViewById
    ViewPager pager;

    @OptionsMenuItem
    MenuItem menuSearch;

// <Initialization>
    @AfterViews
    protected void init() {
        setUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean b = super.onCreateOptionsMenu(menu);

        SearchView v = (SearchView) menuSearch.getActionView();
        v.setOnQueryTextListener(this);

        return b;
    }

//    @UiThread
    protected void setUpViewPager() {
        String title = show != null ? show.getName() : "TvMze";
        getSupportActionBar().setTitle(title);
        adapter = new HomePagerAdapter(getSupportFragmentManager());
        adapter.setShow(show);
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }
// </Initialization>

// <Callbacks>
    @OptionsItem(R.id.menu_bla)
    void menuSearch() {
        Toast.makeText(this, "Clicou!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchShowsByName(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @ItemClick(R.id.list)
    protected void onShowClick(Show show) {
        HomeActivity_.intent(this).show(show).start();
    }
// </Callbacks>

    @Background
    protected void searchShowsByName(String name) {
        shows = showRepository.findByName(name);
        setUpAdapter();
    }

    @UiThread
    protected void setUpAdapter() {
        ArrayAdapter<Show> adapter = new ArrayAdapter<Show>(this, android.R.layout.simple_list_item_1);
        adapter.addAll(shows);
        list.setAdapter(adapter);
    }
}
