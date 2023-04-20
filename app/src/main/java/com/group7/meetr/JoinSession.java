package com.group7.meetr;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.group7.meetr.activity.EmailPasswordActivity;


public class JoinSession {

    private final DatabaseReference mDatabase;

    /**
     * Class constructor. Initializes database reference.
     */
    public JoinSession(FirebaseDatabase database) {
        mDatabase = database.getReference("/Sessions/");
    }

    /**
     * Joins a hardcoded meeting session and adds the signed in user's email address
     */
    public void joinSession() {
        String sessionID = "7";
        mDatabase.child(sessionID).child("Participants").push().setValue(EmailPasswordActivity.getUserMail());
    }
}

