package com.jonathanfinerty.huddlecontacts;

public class Contact {

    private String name;
    private String jobTitle;
    private String avatarUrl;

    public Contact(String name, String jobTitle, String avatarUrl) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
