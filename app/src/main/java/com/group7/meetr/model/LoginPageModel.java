package com.group7.meetr.model;

import androidx.annotation.Nullable;

public class LoginPageModel {
    @Nullable
    String email;

    /**
     * Gets email adress.
     * @return
     */
    @Nullable
    public String getEmail() {
        return email;
    }

    /**
     * Sets email for this model.
     * @param email email to set. example@test.something is correct formatting.
     */
    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    /**
     * Constructor for creating a new LoginPageModel.
     * @param email email entered by form
     */
    public LoginPageModel(String email){
        this.email = email;
    }
}
