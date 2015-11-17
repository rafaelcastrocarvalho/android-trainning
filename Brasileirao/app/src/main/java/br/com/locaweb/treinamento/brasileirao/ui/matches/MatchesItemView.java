package br.com.locaweb.treinamento.brasileirao.ui.matches;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;

import br.com.locaweb.treinamento.brasileirao.R;
import br.com.locaweb.treinamento.brasileirao.domain.Match;
import br.com.locaweb.treinamento.brasileirao.domain.shared.DateFormater;
import br.com.locaweb.treinamento.brasileirao.ui.details.TeamDetailsActivity_;

@EViewGroup(R.layout.matches_item)
public class MatchesItemView extends LinearLayout {

    @ViewById TextView date;
    @ViewById TextView place;

    @ViewById ImageView logoHome;
    @ViewById TextView homeName;
    @ViewById TextView homeScore;

    @ViewById ImageView logoAway;
    @ViewById TextView awayName;
    @ViewById TextView awayScore;

    private Match match;

    public MatchesItemView(Context context) {
        super(context);
    }

    @Click({R.id.logo_home, R.id.logo_away})
    protected void onTeamClick(View v) {
        long teamId;

        if (v == logoHome) {
            teamId = match.getHomeTeam().getId();
        } else {
            teamId = match.getAwayTeam().getId();
        }

        TeamDetailsActivity_.intent(getContext()).teamId(teamId).start();
    }

    public void bind(Match match) {
        this.match = match;

        date.setText(DateFormater.format(match.getDate()));
        place.setText(match.getPlace());

        Picasso.with(getContext()).load(match.getHomeTeam().getLogoUrl()).into(logoHome);
        homeScore.setText("" + match.getHomeTeamScore());
        homeName.setText(match.getHomeTeam().getName());

        Picasso.with(getContext()).load(match.getAwayTeam().getLogoUrl()).into(logoAway);
        awayScore.setText("" + match.getAwayTeamScore());
        awayName.setText(match.getAwayTeam().getName());
    }
}
