package com.group7.meetr.viewmodel;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.firebase.database.FirebaseDatabase;
import com.group7.meetr.BR;
import com.group7.meetr.JoinSession;
import com.group7.meetr.NewSession;
import com.group7.meetr.activity.EmailPasswordActivity;
import com.group7.meetr.model.LoginPageModel;

public class LoginPageViewModel extends BaseObservable {

    // creating object of Model class
    private LoginPageModel model;

    // string variables for
    // toast messages
    private String successMessage = "Login successful";
    private String errorMessage = "Email or Password is not valid";

    @Bindable
    private String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }


    @Bindable
    public String getUserEmail() {
        return model.getEmail();
    }

    public void setUserEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }


    @Bindable
    public String getUserPassword() {
        return model.getPassword();
    }

    public void setUserPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }


    public LoginPageViewModel() {

        // instantiating object of
        // model class
        model = new LoginPageModel("","");
    }


    public void onButtonClicked() {
        if (isValid()) {

            Log.d("!User Email", getUserEmail());
            Log.d("!User Pass", getUserPassword());
            EmailPasswordActivity emailLogIn = new EmailPasswordActivity();
            EmailPasswordActivity.login();
            emailLogIn.signIn(getUserEmail(), getUserPassword());
            setToastMessage(successMessage);
        }
        else
            setToastMessage(errorMessage);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://meetr-android-default-rtdb.europe-west1.firebasedatabase.app/");

        if(getUserEmail().contains("admin@admin.com")) {
            NewSession newSession = new NewSession(database);
            newSession.createSession();
        } else {
            JoinSession joinSession = new JoinSession(database);
            joinSession.joinSession();
        }
    }


    public boolean isValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }
}