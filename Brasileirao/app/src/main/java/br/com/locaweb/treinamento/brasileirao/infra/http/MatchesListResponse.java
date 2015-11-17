package br.com.locaweb.treinamento.brasileirao.infra.http;

import java.util.Date;
import java.util.List;

import br.com.locaweb.treinamento.brasileirao.domain.Match;

public class MatchesListResponse {

    private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
