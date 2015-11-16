package br.com.locaweb.treinamento.brasileirao.ui.matches;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;

import br.com.locaweb.treinamento.brasileirao.R;
import br.com.locaweb.treinamento.brasileirao.domain.Match;
import br.com.locaweb.treinamento.brasileirao.domain.shared.DateFormater;

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

    public MatchesItemView(Context context) {
        super(context);
    }

    public void bind(Match match) {
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
