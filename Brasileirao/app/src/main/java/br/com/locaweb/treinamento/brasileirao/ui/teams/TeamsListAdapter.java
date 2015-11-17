package br.com.locaweb.treinamento.brasileirao.ui.teams;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

import br.com.locaweb.treinamento.brasileirao.domain.Team;
import br.com.locaweb.treinamento.brasileirao.ui.shared.BrasileiraoAdapter;

@EBean
public class TeamsListAdapter extends BrasileiraoAdapter<Team> {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = TeamsListItemView_.build(ctx);
        }

        ((TeamsListItemView) convertView).bind(((Team) getItem(position)));

        return convertView;
    }
}
