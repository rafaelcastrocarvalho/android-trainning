package br.com.locaweb.treinamento.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_scroll)
public class ScrollActivity extends AppCompatActivity {

    private static final int REQUEST_LOGIN = 1234;

    @AfterViews
    protected void init() {

    }

    @Click(R.id.btn_cancelar)
    protected void cancel() {
        Toast.makeText(this, "Flw url_f_open!!", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Click(R.id.btn_ok)
    protected void accept() {
        MainActivity_.intent(this).startForResult(REQUEST_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( requestCode == REQUEST_LOGIN && resultCode == RESULT_OK) {
           if(data != null)  {
               goToWelcomeActivity(data.getStringExtra("login"));
               finish();
           }
        }
    }

    private void goToWelcomeActivity(String login) {
        WelcomeActivity_.intent(this).login(login).start();
    }
}
