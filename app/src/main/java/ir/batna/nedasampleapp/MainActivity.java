package ir.batna.nedasampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import ir.batna.nedasdk.Neda;
import ir.batna.nedasdk.OnClientRegisteredListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Neda.register(this, new OnClientRegisteredListener() {
            @Override
            public void onClientRegistered(String token) {

                // do what u want here
            }
        });
    }
}