package br.com.locaweb.treinamento.brasileirao.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import br.com.locaweb.treinamento.brasileirao.infra.http.MyGsonHttpMessageConverter;


@Table(name = "matches")
public class Match extends Model {

    @SerializedName("home_team_score")
    @Column
    private int homeTeamScore;

    @SerializedName("away_team_score")
    @Column
    private int awayTeamScore;

    @SerializedName("home_team")
    @Column
    private Team homeTeam;

    @SerializedName("away_team")
    @Column
    private Team awayTeam;

    @Column
    private int round;

    @SerializedName("season_id")
    @Column
    private int seasonId;

    @Column
    private String place;

    @Column
    private Date date;

    public Match() { }

    public Match(Team homeTeam, int homeTeamScore, Team awayTeam, int awayTeamScore, String place, int round) {
        this.homeTeam = homeTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeam = awayTeam;
        this.awayTeamScore = awayTeamScore;
        this.place = place;
        this.round = round;
        this.date = new Date();
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
