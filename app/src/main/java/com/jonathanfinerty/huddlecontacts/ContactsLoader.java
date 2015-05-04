package com.jonathanfinerty.huddlecontacts;

import java.util.ArrayList;
import java.util.List;

public class ContactsLoader {

    public List<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Bob Jones", "Developer", "https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"));
        contacts.add(new Contact("Geoff Daily", "Manager", "https://s3.amazonaws.com/uifaces/faces/twitter/gerrenlamson/128.jpg"));
        contacts.add(new Contact("Samantha King", "Manager", "https://s3.amazonaws.com/uifaces/faces/twitter/adellecharles/128.jpg"));
        contacts.add(new Contact("Christoper Smith", "UI Designer", "https://s3.amazonaws.com/uifaces/faces/twitter/soffes/128.jpg"));
        contacts.add(new Contact("Alfred Grimble", "QA Engineer", "https://s3.amazonaws.com/uifaces/faces/twitter/dannpetty/128.jpg"));
        contacts.add(new Contact("Bob Jones", "Developer", "https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"));
        contacts.add(new Contact("Geoff Daily", "Manager", "https://s3.amazonaws.com/uifaces/faces/twitter/gerrenlamson/128.jpg"));
        contacts.add(new Contact("Samantha King", "Manager", "https://s3.amazonaws.com/uifaces/faces/twitter/adellecharles/128.jpg"));
        contacts.add(new Contact("Christoper Smith", "UI Designer", "https://s3.amazonaws.com/uifaces/faces/twitter/soffes/128.jpg"));
        contacts.add(new Contact("Alfred Grimble", "QA Engineer", "https://s3.amazonaws.com/uifaces/faces/twitter/dannpetty/128.jpg"));
        contacts.add(new Contact("Bob Jones", "Developer", "https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"));
        contacts.add(new Contact("Geoff Daily", "Manager", "https://s3.amazonaws.com/uifaces/faces/twitter/gerrenlamson/128.jpg"));
        contacts.add(new Contact("Samantha King", "Manager", "https://s3.amazonaws.com/uifaces/faces/twitter/adellecharles/128.jpg"));
        contacts.add(new Contact("Christoper Smith", "UI Designer", "https://s3.amazonaws.com/uifaces/faces/twitter/soffes/128.jpg"));
        contacts.add(new Contact("Alfred Grimble", "QA Engineer", "https://s3.amazonaws.com/uifaces/faces/twitter/dannpetty/128.jpg"));

        return contacts;
    }

}
