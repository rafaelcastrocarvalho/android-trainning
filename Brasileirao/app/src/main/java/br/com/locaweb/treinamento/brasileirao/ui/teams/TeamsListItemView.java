package br.com.locaweb.treinamento.brasileirao.ui.teams;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.treinamento.brasileirao.R;
import br.com.locaweb.treinamento.brasileirao.domain.Team;

@EViewGroup(R.layout.teams_list_item)
public class TeamsListItemView extends LinearLayout {

    @ViewById TextView name;

    @ViewById ImageView logo;

    public TeamsListItemView(Context context) {
        super(context);
    }

    @AfterViews
    protected void init() {
        setOrientation(HORIZONTAL);
    }

    public void bind(Team team) {
        name.setText(team.getName());
        Picasso.with(getContext()).load(team.getLogoUrl()).into(logo);
//        logo.setImageResource(R.drawable.palmeiras);
    }
}
