package br.com.locaweb.treinamento.tvmaze.ui.episodes;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.EBean;

import br.com.locaweb.treinamento.tvmaze.R;
import br.com.locaweb.treinamento.tvmaze.model.Episode;
import br.com.locaweb.treinamento.tvmaze.ui.shared.AbstractAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

@EBean
public class EpisodeAdapter extends AbstractAdapter<Episode> implements StickyListHeadersAdapter {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EpisodeView view = ((EpisodeView) convertView);

        if(view == null) view = EpisodeView_.build(ctx);
        view.bind(getItem(position));

        return view;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) convertView;
        if(textView == null) {
            textView = new TextView(ctx);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                textView.setBackgroundColor(ctx.getResources().getColor(R.color.colorAccent));
            } else {
                textView.setBackgroundColor(ctx.getColor(R.color.colorAccent));
            }
            textView.setTextColor(Color.WHITE);
            textView.setPadding(10, 10, 10, 10);
        }
        textView.setText(String.format("Temporada %s", getItem(position).getSeason()));
        return textView;
    }

    @Override
    public long getHeaderId(int position) {
        return getItem(position).getSeason();
    }
}
