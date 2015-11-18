package br.com.locaweb.treinamento.tvmaze.infra;

import br.com.locaweb.treinamento.tvmaze.model.Show;

public class SearchResponse {

    private Double score;

    private Show show;

    public Double getScore() {
        return score;
    }

    public Show getShow() {
        return show;
    }
}
