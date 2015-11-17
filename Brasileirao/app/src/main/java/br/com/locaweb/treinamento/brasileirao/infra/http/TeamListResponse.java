package br.com.locaweb.treinamento.brasileirao.infra.http;

import java.util.List;

import br.com.locaweb.treinamento.brasileirao.domain.Team;

public class TeamListResponse {

    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
