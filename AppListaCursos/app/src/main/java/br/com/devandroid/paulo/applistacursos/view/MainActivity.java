package br.com.devandroid.paulo.applistacursos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.devandroid.paulo.applistacursos.R;
//classe que vai instaciar o xml do layout
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}