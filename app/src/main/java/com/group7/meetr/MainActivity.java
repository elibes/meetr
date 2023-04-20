package com.group7.meetr;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import com.group7.meetr.databinding.Loginpagev2Binding;
import com.group7.meetr.viewmodel.LoginPageViewModel;
import com.group7.meetr.activity.EmailPasswordActivity;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // ViewModel updates the Model
        // after observing changes in the View

        // model will also update the view
        // via the ViewModel

        LoginPageViewModel lpvm = new LoginPageViewModel();
        Loginpagev2Binding activityMainBinding
                = DataBindingUtil.setContentView(
                this, R.layout.loginpagev2);
        activityMainBinding.setViewModel(lpvm);
        activityMainBinding.executePendingBindings();
    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

    }

    @BindingAdapter({ "toastMessage" })
    public static void runMe(View view, String message)
    {
        if (message != null)
            Toast
                    .makeText(view.getContext(), message,
                            Toast.LENGTH_SHORT)
                    .show();
    }
}