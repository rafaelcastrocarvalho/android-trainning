package br.com.locaweb.treinamento.brasileirao.ui.teams;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import br.com.locaweb.treinamento.brasileirao.R;


@EActivity(R.layout.activity_teams_list)
public class TeamsListActivity extends AppCompatActivity {

//    @AfterViews
//    public void init() {
//        final FragmentManager manager = getSupportFragmentManager();
//        final FragmentTransaction transaction = manager.beginTransaction();
//
//        final TeamsListFragment fragment = TeamsListFragment_.builder().build();
//
//        transaction.add(R.id.content, fragment);
//        transaction.commit();
//    }
}
