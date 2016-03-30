package br.com.locaweb.treinamento.tvmaze.infra;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;
import java.util.Collection;

import br.com.locaweb.treinamento.tvmaze.model.CastMember;
import br.com.locaweb.treinamento.tvmaze.model.Episode;
import br.com.locaweb.treinamento.tvmaze.model.Show;
import br.com.locaweb.treinamento.tvmaze.model.ShowRepository;

@EBean
public class ShowRepositoryImpl implements ShowRepository {

    @RestService
    protected TvMazeClient tvMazeClient;

    @Override
    public Show findById(Long id) {
        return tvMazeClient.getShow(id);
    }

    @Override
    public Collection<Episode> listShowEpisodes(Long showId) {
        return tvMazeClient.getShowEpisodes(showId);
    }

    @Override
    public Collection<Show> listShows(int page) {
        return tvMazeClient.getShows(page);
    }

    @Override
    public Collection<CastMember> getCast(Long showId) {
        return tvMazeClient.getShowCast(showId);
    }

    @Override
    public Collection<Show> findByName(String showName) {
        Collection<SearchResponse> responses = tvMazeClient.search(showName);
        Collection<Show> shows = new ArrayList<>(responses.size()) ;
        for (SearchResponse response : responses) {
            shows.add(response.getShow());
        }
        return shows;
    }
}
