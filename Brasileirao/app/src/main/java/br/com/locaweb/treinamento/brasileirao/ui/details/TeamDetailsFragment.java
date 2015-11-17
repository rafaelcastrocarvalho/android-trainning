package br.com.locaweb.treinamento.brasileirao.ui.details;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.activeandroid.Model;
import com.activeandroid.query.Select;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.UiThread;

import java.util.List;

import br.com.locaweb.treinamento.brasileirao.R;
import br.com.locaweb.treinamento.brasileirao.domain.Match;
import br.com.locaweb.treinamento.brasileirao.domain.Team;
import br.com.locaweb.treinamento.brasileirao.ui.matches.MatchesAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

@EFragment(R.layout.frag_matches)
public class TeamDetailsFragment extends ListFragment {

    @Bean
    MatchesAdapter adapter;

    @FragmentArg
    Long teamId;

    @AfterViews
    protected void init() {
        fetchData();
    }

    @Background
    protected void fetchData() {
        List<Match> matches = getMatches();
        adapter.setList(matches);
        setListAdapter(adapter);
    }

    @UiThread
    protected void setListAdapter(StickyListHeadersAdapter adapter) {
        super.setListAdapter(adapter);
    }


    private List<Match> getMatches() {
        return new Select().from(Match.class)
                           .where("homeTeam = ?", teamId)
                           .or("awayTeam = ?", teamId)
                           .execute();
    }
}
