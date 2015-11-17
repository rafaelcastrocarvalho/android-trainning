package br.com.locaweb.treinamento.brasileirao.infra.http;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Rest(rootUrl = "http://mockbrasileirao.herokuapp.com/api", converters = MyGsonHttpMessageConverter.class)
public interface RestTemplate {

    @Get("/teams")
    public TeamListResponse getTeams();

    @Get("/matches")
    public MatchesListResponse getMatches();
}
