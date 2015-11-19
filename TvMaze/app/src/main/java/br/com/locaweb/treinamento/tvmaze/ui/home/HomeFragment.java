package br.com.locaweb.treinamento.tvmaze.ui.home;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import br.com.locaweb.treinamento.tvmaze.R;
import br.com.locaweb.treinamento.tvmaze.model.Show;

@EFragment(R.layout.home)
public class HomeFragment extends Fragment {

    @FragmentArg
    protected Show show;

    @ViewById
    ImageView picture;

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

}
