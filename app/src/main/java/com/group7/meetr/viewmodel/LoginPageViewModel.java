package com.group7.meetr.viewmodel;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.group7.meetr.BR;
import com.group7.meetr.model.LoginPageModel;

public class LoginPageViewModel extends BaseObservable {

    //view models implement a private instance of their respective model
    LoginPageModel lgnPage;
    private String successMessage = "Logged in to meeting";
    //private String errorMessage = "Email is not valid";
    @Bindable
    // string variable for success/fail toast message. bound to toast.
    private String toastMessage = null;
    public String getToastMessage() {
        return toastMessage;
    }
    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
    }
    public String getMEmailAdress(){
        return lgnPage.getEmail();
    }
    public void setMEmailAdress(String s){
        lgnPage.setEmail(s);
        notifyPropertyChanged(BR.viewModel);
    }
    // constructor of ViewModel class
    public LoginPageViewModel() {

        // instantiating object of
        // model class
        lgnPage = new LoginPageModel("");
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    public void onButtonClicked() {
        if (isValid()){
            setToastMessage(successMessage);
            Log.d("LOGIN", "Passed email check.");
        }
    }

    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    public boolean isValid() {
        return !TextUtils.isEmpty(getMEmailAdress()) && Patterns.EMAIL_ADDRESS.matcher(getMEmailAdress()).matches();
    }
}
