package br.com.locaweb.treinamento.brasileirao.ui.matches;

import android.support.v4.app.Fragment;

import com.activeandroid.query.Select;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
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

    private List<Match> createMatches() {
        List<Match> matches = new ArrayList<>();

        Team palmeiras      = new Select().from(Team.class).where("name = ?", "Palmeiras").executeSingle();
        Team curintia       = new Select().from(Team.class).where("name = ?", "Curintia").executeSingle();
        Team cruzeiro       = new Select().from(Team.class).where("name = ?", "Cruzeiro").executeSingle();
        Team atletico       = new Select().from(Team.class).where("name = ?", "Atlético-MG").executeSingle();
        Team internacional  = new Select().from(Team.class).where("name = ?", "Internacional").executeSingle();
        Team gremio         = new Select().from(Team.class).where("name = ?", "Gremio").executeSingle();
        Team saoPaulo       = new Select().from(Team.class).where("name = ?", "São Paulo").executeSingle();
        Team santos         = new Select().from(Team.class).where("name = ?", "Santos").executeSingle();

        matches.add(new Match(palmeiras, 4, curintia, 1, "Allians Parque, São Paulo", 1));
        matches.add(new Match(saoPaulo, 1, santos, 1, "Morumbi, São Paulo", 1));
        matches.add(new Match(internacional, 2, gremio, 1, "Sei lá, São Paulo", 1));
        matches.add(new Match(cruzeiro, 3, atletico, 3, "Toca da Raposa, São Paulo", 1));
        matches.add(new Match(curintia, 1, palmeiras, 3, "Impressorão, São Paulo", 1));

        matches.add(new Match(palmeiras, 4, curintia, 1, "Allians Parque, São Paulo", 2));
        matches.add(new Match(saoPaulo, 1, santos, 1, "Morumbi, São Paulo", 2));
        matches.add(new Match(internacional, 2, gremio, 1, "Sei lá, São Paulo", 2));
        matches.add(new Match(cruzeiro, 3, atletico, 3, "Toca da Raposa, São Paulo", 2));
        matches.add(new Match(curintia, 1, palmeiras, 3, "Impressorão, São Paulo", 2));

        return matches;

//        for (Match match: matches) {
//           match.save();
//        }
    }

    public List<Match> getMatches() {
        return new Select().all().from(Match.class).execute();
    }

}