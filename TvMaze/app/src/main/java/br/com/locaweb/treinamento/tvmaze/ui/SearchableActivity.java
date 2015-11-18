package br.com.locaweb.treinamento.tvmaze.ui;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import br.com.locaweb.treinamento.tvmaze.R;

@EActivity(R.layout.home)
public class SearchableActivity extends AppCompatActivity {

//    @ViewById
//    ListView list;
//
//    @Bean(value = ShowRepositoryImpl.class)
//    protected ShowRepository showRepository;
//
//    Collection<Show> shows;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        Intent intent = getIntent();
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            doMySearch(query);
//        }
//    }
//
//    @Background
//    protected void doMySearch(String query) {
//        shows = showRepository.findByName(query);
//    }
//
//    @UiThread
//    protected void setUpAdapter() {
//        ArrayAdapter<Show> adapter = new ArrayAdapter<Show>(this, android.R.layout.simple_list_item_1);
//        adapter.addAll(shows);
//        list.setAdapter(adapter);
//    }


    @AfterViews
    protected void init() {
        Toast.makeText(this, "Bla", Toast.LENGTH_SHORT);
    }
}
