package br.com.locaweb.treinamento.brasileirao.ui.matches;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.activeandroid.query.Select;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import br.com.locaweb.treinamento.brasileirao.R;
import br.com.locaweb.treinamento.brasileirao.domain.Match;
import br.com.locaweb.treinamento.brasileirao.domain.Team;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

@EFragment(R.layout.frag_matches)
public class MatchesFragment extends Fragment {

    @Bean
    MatchesAdapter adapter;

    @ViewById
    StickyListHeadersListView list;

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
    public void setListAdapter(StickyListHeadersAdapter adapter) {
        list.setAdapter(adapter);
    }

    @ItemClick(android.R.id.list)
    public void onListItemClick(int position) {
        Match match = adapter.getItem(position);
        String score = match.getHomeTeamScore() + " X " + match.getAwayTeamScore();
        Toast.makeText(getActivity(), score, Toast.LENGTH_LONG).show();
    }

    public List<Match> getMatches() {
        if(teamId == null) {
            return new Select().all().from(Match.class).execute();
        } else {
            return new Select().from(Match.class)
                    .where("homeTeam = ?", teamId)
                    .or("awayTeam = ?", teamId)
                    .execute();
        }
    }

}