package br.com.locaweb.treinamento.brasileirao.ui.matches;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.EBean;

import br.com.locaweb.treinamento.brasileirao.R;
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
        TextView textView = new TextView(ctx);
        if(textView == null) {

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                textView.setBackgroundColor(ctx.getResources().getColor(R.color.colorAccent));
            } else {
                textView.setBackgroundColor(ctx.getColor(R.color.colorAccent));
            }
            textView.setTextColor(Color.WHITE);
            textView.setPadding(10, 10, 10, 10);

        }
        textView.setText(String.format("Rodada %s", getItem(position).getRound()));
        return textView;
    }

    @Override
    public long getHeaderId(int position) {
        return getItem(position).getRound();
    }
}
