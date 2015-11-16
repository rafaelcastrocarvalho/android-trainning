package br.com.locaweb.treinamento.adaptertest.planet;

import android.support.v4.app.ListFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;
import java.util.List;

import br.com.locaweb.treinamento.adaptertest.R;

@EFragment
public class PlanetsFragment extends ListFragment {

    @Bean
    PlanetsAdapter adapter;

    @AfterViews
    protected  void init() {
        simulateHeavyPrecessing();
    }

    @Background
    protected  void simulateHeavyPrecessing() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setupList();
    }

    @UiThread
    protected  void setupList() {
        adapter.setPlanetList(populatePlanets());
        setListAdapter(adapter);
    }

    private List<Planet> populatePlanets() {
        ArrayList<Planet> planets = new ArrayList<Planet>();
        planets.add(new Planet("Merkur", R.drawable.merkur));
        planets.add(new Planet("Venera", R.drawable.venera));
        planets.add(new Planet("Zemlja", R.drawable.zemlja));
        planets.add(new Planet("Mars", R.drawable.mars));
        planets.add(new Planet("Jupiter", R.drawable.jupiter));
        planets.add(new Planet("Saturn", R.drawable.saturn));
        planets.add(new Planet("Uran", R.drawable.uran));
        planets.add(new Planet("Neptun", R.drawable.neptun));
        planets.add(new Planet("Pluton", R.drawable.pluton));

        return planets;
    }

}
