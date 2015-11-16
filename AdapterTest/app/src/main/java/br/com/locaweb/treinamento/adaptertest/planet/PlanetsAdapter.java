package br.com.locaweb.treinamento.adaptertest.planet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class PlanetsAdapter extends BaseAdapter {

    @RootContext
    protected Context ctx;

    private List<Planet> planetList;

    @Override
    public int getCount() {
        return planetList.size();
    }

    @Override
    public Object getItem(int position) {
        return planetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView =  PlanetItemView_.build(ctx);
        }

        ((PlanetItemView) convertView).bind(((Planet) getItem(position)));

        return  convertView;
    }

    public void setPlanetList(List<Planet> planets) {
        this.planetList = planets;
    }
}
