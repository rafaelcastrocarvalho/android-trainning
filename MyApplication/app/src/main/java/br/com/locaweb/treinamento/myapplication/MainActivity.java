package br.com.locaweb.treinamento.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.login) EditText editLogin;

    @ViewById(R.id.senha) EditText editPassword;

    @Click
    public void doLogin(View view) {
        String login  = editLogin.getText().toString();
        String passwd = editPassword.getText().toString();

        if("Locaweb".equals(login) && "1234".equals(passwd)) {
//            goToWelcomeActivity(login);
            final Intent data = new Intent();
            data.putExtra("login", login);
            setResult(Activity.RESULT_OK, data);
            finish();
        } else {
            Toast.makeText(this, "Mentiroso! Caluniador!", Toast.LENGTH_SHORT).show();
            editPassword.getText().clear();
        }
    }
}
