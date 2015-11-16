package br.com.locaweb.treinamento.brasileirao.ui.teams;

import android.support.v4.app.ListFragment;

import com.activeandroid.query.Select;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;
import java.util.List;

import br.com.locaweb.treinamento.brasileirao.domain.Team;

@EFragment
public class TeamsListFragment extends ListFragment {

    @Bean
    TeamsListAdapter adapter;
    private List<Team> allTeams;

    @AfterViews
    protected void init() {
        fetchData();
    }

    @Background
    public void fetchData() {
        adapter.setTeams(getAllTeams());
        setListAdapter();
    }

    @UiThread
    public void setListAdapter() {
       super.setListAdapter(adapter);
    }

    private void createTeams() {
        List<Team> teamsList = new ArrayList<>();

        teamsList.add(new Team("Palmeiras", "http://www.ogol.com.br/img/logos/equipas/2248_imgbank.png"));
        teamsList.add(new Team("Curintia", "http://www.ogol.com.br/img/logos/equipas/2234_imgbank.png"));
        teamsList.add(new Team("Cruzeiro", "http://www.ogol.com.br/img/logos/equipas/2236_imgbank.png"));
        teamsList.add(new Team("Atlético-MG", "http://www.ogol.com.br/img/logos/equipas/2229_imgbank.png"));
        teamsList.add(new Team("Internacional", "http://www.ogol.com.br/img/logos/equipas/2245_imgbank.png"));
        teamsList.add(new Team("Gremio", "http://www.ogol.com.br/img/logos/equipas/2243_imgbank.png"));
        teamsList.add(new Team("São Paulo", "http://www.ogol.com.br/img/logos/equipas/2256_imgbank.png"));
        teamsList.add(new Team("Santos", "http://www.ogol.com.br/img/logos/equipas/2254_imgbank.png"));

        for (Team team : teamsList) {
            team.save();
        }
    }

    public List<Team> getAllTeams() {
        return new Select().all().from(Team.class).execute();
    }
}