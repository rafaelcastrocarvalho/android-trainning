package br.com.locaweb.treinamento.tvmaze.ui.cast;

import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;

import br.com.locaweb.treinamento.tvmaze.model.CastMember;
import br.com.locaweb.treinamento.tvmaze.ui.shared.AbstractAdapter;

@EBean
public class CastAdapter extends AbstractAdapter<CastMember> {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CastMemberView view = ((CastMemberView) convertView);

        if(view == null) view = CastMemberView_.build(ctx);
        view.bind(getItem(position));

        return view;
    }
}
