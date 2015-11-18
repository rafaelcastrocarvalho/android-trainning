package br.com.locaweb.treinamento.tvmaze.ui.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.treinamento.tvmaze.R;
import br.com.locaweb.treinamento.tvmaze.model.Show;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class HomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @Extra
    Show show;

    @ViewById
    TabLayout tabs;

    @ViewById
    ViewPager pager;

    @OptionsMenuItem
    MenuItem menuSearch;

    @OptionsItem(R.id.menu_search)
    boolean menuSearch() {
        menuSearch.setVisible(false);
        // menuSearch was selected
        // the return type may be void or boolean (false to allow normal menu processing to proceed, true to consume it here)
        Toast.makeText(this, "BLA", Toast.LENGTH_SHORT);
        return true;
    }

    HomePagerAdapter adapter;

    @AfterViews
    protected void init() {
        setUpViewPager();
    }

    @UiThread
    protected void setUpViewPager() {
        String title = show != null ? show.getName() : "TvMze";
        getSupportActionBar().setTitle(title);
        adapter = new HomePagerAdapter(getSupportFragmentManager());
        adapter.setShow(show);
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this, "BLA", Toast.LENGTH_SHORT);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(this, "BLA", Toast.LENGTH_SHORT);
        return false;
    }
}
