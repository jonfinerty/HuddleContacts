package com.jonathanfinerty.huddlecontacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ContactActivity extends ActionBarActivity {

    public static final String INTENT_EXTRA_CONTACT_ID = "contact_id";
    private String contactId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contactId = getIntent().getStringExtra(INTENT_EXTRA_CONTACT_ID);
    }
}


