package com.group7.meetr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpagev2); // set till en xml view


    }

    // any change in toastMessage attribute
// defined on the Button with bind prefix
// invokes this method
    @BindingAdapter({ "toastMessage" })
    public static void runMe(View view, String message) {
        if (message != null)
            Toast
                    .makeText(view.getContext(), message,
                            Toast.LENGTH_SHORT)
                    .show();
    }
}