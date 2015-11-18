package br.com.locaweb.treinamento.tvmaze.infra;

import android.app.IntentService;
import android.content.Intent;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.ServiceAction;

import java.util.Collection;

import br.com.locaweb.treinamento.tvmaze.model.Episode;
import br.com.locaweb.treinamento.tvmaze.model.Show;
import br.com.locaweb.treinamento.tvmaze.model.ShowRepository;

@EIntentService
public class TvShowIntentService extends IntentService {

    public static final String ACTION_GET_SHOW = "ACTION_GET_SHOW";
    public static final String ACTION_GET_SHOW_EPISODES = "ACTION_GET_SHOW_EPISODES";

    public static final String EXTRA_SHOW = "show";
    public static final String EXTRA_SHOW_EPISODES = "episodes";

    @Bean(value = ShowRepositoryImpl.class)
    protected ShowRepository showRepository;

    public TvShowIntentService() {
        super("TvShowIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
    }

    @ServiceAction
    public void fetchShow(Long showId) {
        Show show = showRepository.findById(showId);
        Intent intent = new Intent(ACTION_GET_SHOW);
        intent.putExtra(EXTRA_SHOW, show);
        sendBroadcast(intent);
    }

    @ServiceAction
    public void fetchEpisodes(Long showId) {
        Collection<Episode> episodes = showRepository.listShowEpisodes(showId);
        Intent intent = new Intent(ACTION_GET_SHOW_EPISODES);
        intent.putExtra(EXTRA_SHOW_EPISODES, episodes.toArray());
        sendBroadcast(intent);
    }
}
