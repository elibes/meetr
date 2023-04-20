package com.group7.meetr;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

/**
 * Responsible for creating a new meeting session in Firebase Realtime Database.
 */
public class NewSession {
    private final DatabaseReference mDatabase;

    /**
     * Class constructor. Initializes database reference.
     */
    public NewSession(FirebaseDatabase database) {
        mDatabase = database.getReference("/Sessions/");
    }

    /**
     * Adds a session identification number in database as a child to "Sessions";
     * represents the existence of a meeting session, as well as the current moderator
     * under the created session.
     */
    public void createSession() {
        Random rand = new Random();
        String sessionID = String.valueOf(rand.nextInt(9999999));
        mDatabase.child(sessionID).child("Moderator").setValue("User ID / Name here");
    }
}
