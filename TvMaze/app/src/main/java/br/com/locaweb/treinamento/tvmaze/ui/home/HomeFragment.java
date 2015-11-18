package br.com.locaweb.treinamento.tvmaze.ui.home;

import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.Collection;

import br.com.locaweb.treinamento.tvmaze.R;
import br.com.locaweb.treinamento.tvmaze.infra.ShowRepositoryImpl;
import br.com.locaweb.treinamento.tvmaze.model.Show;
import br.com.locaweb.treinamento.tvmaze.model.ShowRepository;

@EFragment(R.layout.home)
public class HomeFragment extends Fragment {

    @FragmentArg
    protected Show show;

    @ViewById
    EditText search;

    @ViewById
    ListView list;

    @ViewById
    ImageView picture;


    @Bean(value = ShowRepositoryImpl.class)
    ShowRepository showRepository;

    private Collection<Show> shows;

    @AfterViews
    protected void init() {
        if(show != null) {
            setImage();
//            TvShowIntentService_.intent(getContext()).fetchShow(show.getId()).start();
        }
    }

    protected void setImage() {
        Picasso.with(getContext()).load(show.getImage().getOriginal()).into(picture);
    }

//    @Receiver(actions = TvShowIntentService.ACTION_GET_SHOW)
//    protected void actionServiceDone(@Receiver.Extra Show show) {
//        Toast.makeText(getContext(), show.getImage().getOriginal(), Toast.LENGTH_SHORT).show();
//    }

    @Click(R.id.btn_search)
    protected void onSearch() {
        String showName = search.getText().toString();
        searchShowsByName(showName);
    }

    @ItemClick(R.id.list)
    protected void onShowClick(Show show) {
        HomeActivity_.intent(getContext()).show(show).start();
    }

    @Background
    protected void searchShowsByName(String name) {
        shows = showRepository.findByName(name);
        setUpAdapter();
    }

    @UiThread
    protected void setUpAdapter() {
        ArrayAdapter<Show> adapter = new ArrayAdapter<Show>(getContext(), android.R.layout.simple_list_item_1);
        adapter.addAll(shows);
        list.setAdapter(adapter);
    }
}
