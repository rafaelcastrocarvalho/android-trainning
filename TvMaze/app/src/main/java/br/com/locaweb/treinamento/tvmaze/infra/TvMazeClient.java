package br.com.locaweb.treinamento.tvmaze.infra;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.Collection;
import java.util.List;

import br.com.locaweb.treinamento.tvmaze.model.Cast;
import br.com.locaweb.treinamento.tvmaze.model.CastMember;
import br.com.locaweb.treinamento.tvmaze.model.Episode;
import br.com.locaweb.treinamento.tvmaze.model.Show;

@Rest(rootUrl = "http://api.tvmaze.com", converters = GsonHttpMessageConverter.class)
public interface TvMazeClient {

    @Get("/shows/{id}")
    public Show getShow(long id);

    @Get("/shows/{id}/episodes")
    public Collection<Episode> getShowEpisodes(long id);

    @Get("/shows?page={page}")
    public Collection<Show> getShows(int page);

    @Get("/shows/{id}/cast")
    public Collection<CastMember> getShowCast(long id);

    @Get("/search/shows?q={showName}")
    public Collection<SearchResponse> search(String showName);
}
