package ir.batna.nedasampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ir.batna.nedasdk.Neda;
import ir.batna.nedasdk.OnClientRegisteredListener;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView copy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        copy = findViewById(R.id.copy);
        Neda.register(this, new OnClientRegisteredListener() {
            @Override
            public void onClientRegistered(final String token) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Your token is: " + token);
                        copy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clip = ClipData.newPlainText("token", token);
                                clipboard.setPrimaryClip(clip);
                                Toast.makeText(getApplicationContext(), "Token copied!", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                // do what u want here
            }
        });
    }
}