package br.com.locaweb.treinamento.brasileirao.ui.matches;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.EBean;

import br.com.locaweb.treinamento.brasileirao.domain.Match;
import br.com.locaweb.treinamento.brasileirao.ui.shared.BrasileiraoAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

@EBean
public class MatchesAdapter extends BrasileiraoAdapter<Match> implements StickyListHeadersAdapter {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) convertView = MatchesItemView_.build(ctx);
        ((MatchesItemView) convertView).bind(((Match) getItem(position)));
        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) convertView = new TextView(ctx);
        ((TextView) convertView).setText(String.format("Rodada %s", getItem(position).getRound()));
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return getItem(position).getRound();
    }
}
