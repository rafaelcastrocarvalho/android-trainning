package br.com.locaweb.treinamento.tvmaze.ui.episodes;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import br.com.locaweb.treinamento.tvmaze.R;
import br.com.locaweb.treinamento.tvmaze.infra.ShowRepositoryImpl;
import br.com.locaweb.treinamento.tvmaze.infra.TvShowIntentService;
import br.com.locaweb.treinamento.tvmaze.model.Episode;
import br.com.locaweb.treinamento.tvmaze.model.Show;
import br.com.locaweb.treinamento.tvmaze.model.ShowRepository;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

@EFragment(R.layout.episodes)
public class EpisodesFragment extends Fragment {

    @FragmentArg
    protected Show show;

    @ViewById
    protected StickyListHeadersListView list;

    @Bean(value = ShowRepositoryImpl.class)
    protected ShowRepository showRepository;

    @Bean
    protected EpisodeAdapter adapter;

    private Collection<Episode> episodes = Collections.emptyList();;

    @AfterViews
    protected void init() {
        fetchData();
//        Long id =  show != null ? show.getId() : SHOW_ID;
//        TvShowIntentService_.intent(getContext()).fetchEpisodes(id).start();
    }

    @Receiver(actions = TvShowIntentService.ACTION_GET_SHOW_EPISODES)
    protected void actionServiceDone(@Receiver.Extra Episode[] episodes) {
        adapter.setList(Arrays.asList(episodes));
    }

    @Background
    protected void fetchData() {
        if(show != null) episodes = showRepository.listShowEpisodes(show.getId());
        configureAdapter();
    }

    @UiThread
    protected void configureAdapter() {
        adapter.setList(new ArrayList<>(episodes));
        list.setAdapter(adapter);
    }
}
