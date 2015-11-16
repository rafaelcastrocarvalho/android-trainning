package br.com.locaweb.treinamento.adaptertest.planet;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.treinamento.adaptertest.R;

@EViewGroup(R.layout.planet_item)
public class PlanetItemView extends LinearLayout {

    @ViewById TextView label;

    @ViewById ImageView image;

    public PlanetItemView(Context context) {
        super(context);
    }

    @AfterViews
    protected void init() {
        setOrientation(HORIZONTAL);
    }

    public void bind(Planet planet) {
        image.setImageResource(planet.getImgRes());
        label.setText(planet.getName());
    }
}
