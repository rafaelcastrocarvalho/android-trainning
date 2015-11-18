package br.com.locaweb.treinamento.tvmaze.ui.cast;

import android.support.v4.app.ListFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;
import java.util.Collection;

import br.com.locaweb.treinamento.tvmaze.infra.ShowRepositoryImpl;
import br.com.locaweb.treinamento.tvmaze.model.CastMember;
import br.com.locaweb.treinamento.tvmaze.model.Show;
import br.com.locaweb.treinamento.tvmaze.model.ShowRepository;

import static br.com.locaweb.treinamento.tvmaze.model.Shows.SHOW_ID;

@EFragment
public class CastFragment extends ListFragment {

    @FragmentArg
    protected Show show;

    @Bean(value = ShowRepositoryImpl.class)
    ShowRepository showRepository;

    @Bean
    protected CastAdapter adapter;

    private Collection<CastMember> cast;

    @AfterViews
    protected void init() {
        fetchData();
    }

    @Background
    protected void fetchData() {
        if(show != null) {
            cast = showRepository.getCast(show.getId());
            configureAdapter();
        }
    }

    @UiThread
    protected void configureAdapter() {
        adapter.setList(new ArrayList<CastMember>(cast));
        setListAdapter(adapter);
    }
}
