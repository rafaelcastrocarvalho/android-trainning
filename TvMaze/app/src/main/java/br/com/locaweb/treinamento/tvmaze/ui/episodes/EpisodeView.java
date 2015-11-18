package br.com.locaweb.treinamento.tvmaze.ui.episodes;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.treinamento.tvmaze.R;
import br.com.locaweb.treinamento.tvmaze.model.Episode;
import br.com.locaweb.treinamento.tvmaze.model.Image;

@EViewGroup(R.layout.episode)
public class EpisodeView extends LinearLayout {

    public EpisodeView(Context context) {
        super(context);
    }

    @ViewById
    ImageView image;

    @ViewById
    protected TextView name;

    public void bind(Episode episode) {
        Image image = episode.getImage();
        if(image != null) {
            Picasso.with(getContext()).load(image.getMedium()).into(this.image);
        }
        name.setText(episode.getName());
    }
}
