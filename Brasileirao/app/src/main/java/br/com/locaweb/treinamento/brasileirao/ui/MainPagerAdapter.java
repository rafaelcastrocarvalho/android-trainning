package br.com.locaweb.treinamento.brasileirao.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.locaweb.treinamento.brasileirao.ui.matches.MatchesFragment_;
import br.com.locaweb.treinamento.brasileirao.ui.teams.TeamsListFragment_;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 2;
    private static final CharSequence[] TITLES = {"Times", "Partidas"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TeamsListFragment_.builder().build();
            case 1:
                return MatchesFragment_.builder().build();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}