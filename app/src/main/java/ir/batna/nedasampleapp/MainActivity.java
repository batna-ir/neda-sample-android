package ir.batna.nedasampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ir.batna.nedasdk.Neda;
import ir.batna.nedasdk.OnClientRegisteredListener;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Neda.register(this, new OnClientRegisteredListener() {
            @Override
            public void onClientRegistered(String token) {

                textView.setText("Your token is: " + token);
                // do what u want here
            }
        });
    }
}