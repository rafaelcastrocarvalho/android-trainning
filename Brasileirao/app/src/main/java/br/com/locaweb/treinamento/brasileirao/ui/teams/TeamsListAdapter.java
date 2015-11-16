package br.com.locaweb.treinamento.brasileirao.ui.teams;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

import br.com.locaweb.treinamento.brasileirao.domain.Team;

@EBean
public class TeamsListAdapter extends BaseAdapter {

    @RootContext protected Context ctx;

    List<Team> teamsList;

    @Override
    public int getCount() {
        return teamsList.size();
    }

    @Override
    public Object getItem(int position) {
        return teamsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = TeamsListItemView_.build(ctx);
        }

        ((TeamsListItemView) convertView).bind(((Team) getItem(position)));

        return convertView;
    }

    public void setTeams(List<Team> teams) {
        this.teamsList = teams;
    }
}
