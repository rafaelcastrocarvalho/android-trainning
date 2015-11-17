package br.com.locaweb.treinamento.brasileirao.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.query.Select;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;
import java.util.List;

import br.com.locaweb.treinamento.brasileirao.R;
import br.com.locaweb.treinamento.brasileirao.domain.Match;
import br.com.locaweb.treinamento.brasileirao.domain.Team;
import br.com.locaweb.treinamento.brasileirao.infra.http.MatchesListResponse;
import br.com.locaweb.treinamento.brasileirao.infra.http.RestTemplate;
import br.com.locaweb.treinamento.brasileirao.infra.http.TeamListResponse;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    ViewPager pager;

    @ViewById
    TabLayout tabs;

    @ViewById
    Toolbar toolbar;

    MainPagerAdapter adapter;

    @RestService
    RestTemplate restTemplate;

    @AfterViews
    protected void init() {
        setSupportActionBar(toolbar);
        fetchData();
    }

    @Background
    protected void fetchData() {
        ActiveAndroid.beginTransaction();
        try {
            TeamListResponse teamListResponse = restTemplate.getTeams();
            for(Team team : teamListResponse.getTeams())  {
                team.save();
            }

            MatchesListResponse matches = restTemplate.getMatches();
            for(Match match : matches.getMatches()) {
                Team home = new Select().from(Team.class).where("name = ?", match.getHomeTeam().getName()).executeSingle();
                Team away = new Select().from(Team.class).where("name = ?", match.getAwayTeam().getName()).executeSingle();
                match.setHomeTeam(home);
                match.setAwayTeam(away);
                match.save();
            }

        } finally {
            ActiveAndroid.setTransactionSuccessful();
        }
        ActiveAndroid.endTransaction();
        setUpViewPager();
    }

    @UiThread
    protected void setUpViewPager() {
        adapter = new MainPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }
}
