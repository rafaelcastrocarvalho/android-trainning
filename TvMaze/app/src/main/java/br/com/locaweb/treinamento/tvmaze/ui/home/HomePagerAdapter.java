package br.com.locaweb.treinamento.tvmaze.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.locaweb.treinamento.tvmaze.model.Show;
import br.com.locaweb.treinamento.tvmaze.ui.cast.CastFragment_;
import br.com.locaweb.treinamento.tvmaze.ui.episodes.EpisodesFragment_;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private static final CharSequence[] TITLES = {"Home", "Episódios", "Cast"};

    private Show show;

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HomeFragment_.builder().show(show).build();
            case 1:
                return EpisodesFragment_.builder().show(show).build();
            case 2:
                return CastFragment_.builder().show(show).build();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
