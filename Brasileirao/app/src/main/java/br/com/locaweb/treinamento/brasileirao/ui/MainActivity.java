package br.com.locaweb.treinamento.brasileirao.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.activeandroid.ActiveAndroid;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import br.com.locaweb.treinamento.brasileirao.R;
import br.com.locaweb.treinamento.brasileirao.domain.Match;
import br.com.locaweb.treinamento.brasileirao.domain.Team;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById ViewPager pager;
    @ViewById TabLayout tabs;

    MainPagerAdapter adapter;

    @AfterViews
    protected void init() {
        fetchData();
    }

    @Background
    protected void fetchData() {
        Team palmeiras      = new Team("Palmeiras", "http://www.ogol.com.br/img/logos/equipas/2248_imgbank.png");
        Team curintia       = new Team("Curintia", "http://www.ogol.com.br/img/logos/equipas/2234_imgbank.png");
        Team cruzeiro       = new Team("Cruzeiro", "http://www.ogol.com.br/img/logos/equipas/2236_imgbank.png");
        Team atletico       = new Team("Atlético-MG", "http://www.ogol.com.br/img/logos/equipas/2229_imgbank.png");
        Team internacional  = new Team("Internacional", "http://www.ogol.com.br/img/logos/equipas/2245_imgbank.png");
        Team gremio         = new Team("Gremio", "http://www.ogol.com.br/img/logos/equipas/2243_imgbank.png");
        Team saoPaulo       = new Team("São Paulo", "http://www.ogol.com.br/img/logos/equipas/2256_imgbank.png");
        Team santos         = new Team("Santos", "http://www.ogol.com.br/img/logos/equipas/2254_imgbank.png");

        List<Match> matches = new ArrayList<>();
        matches.add(new Match(palmeiras, 4, curintia, 1, "Allians Parque, São Paulo", 1));
        matches.add(new Match(saoPaulo, 1, santos, 1, "Morumbi, São Paulo", 1));
        matches.add(new Match(internacional, 2, gremio, 1, "Sei lá, São Paulo", 1));
        matches.add(new Match(cruzeiro, 3, atletico, 3, "Toca da Raposa, São Paulo", 1));
        matches.add(new Match(curintia, 1, palmeiras, 3, "Impressorão, São Paulo", 1));

        matches.add(new Match(palmeiras, 4, curintia, 1, "Allians Parque, São Paulo", 2));
        matches.add(new Match(saoPaulo, 1, santos, 1, "Morumbi, São Paulo", 2));
        matches.add(new Match(internacional, 2, gremio, 1, "Sei lá, São Paulo", 2));
        matches.add(new Match(cruzeiro, 3, atletico, 3, "Toca da Raposa, São Paulo", 2));
        matches.add(new Match(curintia, 1, palmeiras, 3, "Impressorão, São Paulo", 2));

        ActiveAndroid.beginTransaction();
        try {
            palmeiras.save();
            curintia.save();
            cruzeiro.save();
            atletico.save();
            internacional.save();
            gremio.save();
            saoPaulo.save();
            santos.save();

            for (Match match : matches) match.save();

        } finally {
           ActiveAndroid.setTransactionSuccessful();
        }

        ActiveAndroid.endTransaction();
        setUpViewPager();
    }

    @UiThread
    protected void setUpViewPager() {
        adapter = new MainPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }
}
