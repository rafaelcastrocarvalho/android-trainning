package br.com.locaweb.treinamento.adaptertest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import br.com.locaweb.treinamento.adaptertest.planet.PlanetsFragment;
import br.com.locaweb.treinamento.adaptertest.planet.PlanetsFragment_;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @AfterViews
    public void init() {
        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();

//        final MyListFragment fragment = MyListFragment_.builder().qtdListItems(137).build();
//        final ArrayAdapterFragment fragment = ArrayAdapterFragment_.builder().build();
//        final BaseAdapterFragment fragment = BaseAdapterFragment_.builder().build();
        final PlanetsFragment fragment = PlanetsFragment_.builder().build();

        transaction.add(R.id.content, fragment);
        transaction.commit();
    }
}
