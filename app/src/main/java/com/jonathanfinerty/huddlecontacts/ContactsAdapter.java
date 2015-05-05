package com.jonathanfinerty.huddlecontacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> contacts = new ArrayList<>();

    public ContactsAdapter() {}

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.bindContact(contact);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
