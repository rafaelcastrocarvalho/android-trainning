package br.com.locaweb.treinamento.tvmaze.ui.cast;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.treinamento.tvmaze.R;
import br.com.locaweb.treinamento.tvmaze.model.CastMember;

@EViewGroup(R.layout.cast_member)
public class CastMemberView extends LinearLayout {

    public CastMemberView(Context context) {
        super(context);
    }

    @ViewById
    protected ImageView image;

    @ViewById
    protected TextView name;

    @ViewById
    protected TextView character;


    public void bind(CastMember member) {
        Picasso.with(getContext()).load(member.getPerson().getImage().getMedium()).into(image);
        name.setText(member.getPerson().getName());
        character.setText(member.getCharacter().getName());
    }
}
