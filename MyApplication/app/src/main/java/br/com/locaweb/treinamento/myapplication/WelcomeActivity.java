package br.com.locaweb.treinamento.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_welcome)
public class WelcomeActivity extends AppCompatActivity {

    @Extra String login;

    @ViewById(R.id.welcome) TextView textWelcomeMessage;

    @AfterViews
    protected  void init() {
        textWelcomeMessage.setText(getString(R.string.welcome_x, login));
    }
}
