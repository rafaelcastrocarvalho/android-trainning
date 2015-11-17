package br.com.locaweb.treinamento.brasileirao.ui.details;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;

import br.com.locaweb.treinamento.brasileirao.R;
import br.com.locaweb.treinamento.brasileirao.domain.Team;
import br.com.locaweb.treinamento.brasileirao.ui.matches.MatchesFragment;
import br.com.locaweb.treinamento.brasileirao.ui.matches.MatchesFragment_;

@EActivity(R.layout.activity_team_details)
public class TeamDetailsActivity extends AppCompatActivity {

    @Extra
    long teamId;

    @ViewById
    Toolbar toolbar;

    Team team;
    private Bitmap logo;

    @AfterViews
    public void init() {
        setSupportActionBar(toolbar);

        team = Team.load(Team.class, teamId);
        setTitle(team.getName());
        loadTeamLogo();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        MatchesFragment fragment = MatchesFragment_.builder().teamId(teamId).build();
        getSupportFragmentManager().beginTransaction()
                                   .add(R.id.content, fragment)
                                   .commit();

    }

    @OptionsItem(android.R.id.home)
    void onBack() {
        onBackPressed();
    }


    @Background
    protected void loadTeamLogo() {
        try {
            int size = android.R.dimen.app_icon_size;
            Bitmap logo = Picasso.with(this)
                    .load(team.getLogoUrl())
                    .resizeDimen(size, size)
                    .get();
            setLogo(logo);
        } catch (IOException e) {
            setLogo(R.mipmap.ic_launcher);
        }

    }

    @UiThread
    public void setLogo(Bitmap logo) {
        toolbar.setLogo(new BitmapDrawable(getResources(), logo));
    }

    @UiThread
    void setLogo(int logoResId) {
        toolbar.setLogo(logoResId);
    }

}
