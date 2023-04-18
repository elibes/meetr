package com.group7.meetr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page); // set till en xml view
        Button button = (Button) findViewById(R.id.btnConfirmEmail);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "User tapped the Supabutton");
                TextView txt = findViewById(R.id.txtViewHint);
                //txt.setAllCaps(true);
                TextView txt2 = findViewById(R.id.editTextTextEmailAddress);

                Log.d("DEBUG_EMAIL_OUTPUT", txt2.getText().toString());

                // för att få output till nästa steg ta txt2.gettext

            }
        });
    }
}