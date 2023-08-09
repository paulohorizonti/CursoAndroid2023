package br.com.devandroid.paulo.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.com.devandroid.paulo.appgaseta.R;
import br.com.devandroid.paulo.appgaseta.database.GasEtaDb;

public class SplashActivity extends AppCompatActivity {
    public final int TIME_OUT_SPLASH = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comutarTelaSplash();
    }

    private void comutarTelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //criar a tabela
                GasEtaDb db = new GasEtaDb(SplashActivity.this);


                Intent telaPrincipal = new Intent(SplashActivity.this, GasEtaActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT_SPLASH);
    }
}