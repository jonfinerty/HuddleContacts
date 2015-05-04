package com.jonathanfinerty.huddlecontacts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private String contactId;
    private final Context context;
    private final ImageView avatar;
    private final TextView name;
    private final TextView title;

    public ContactViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        context = itemView.getContext();
        avatar = (ImageView) itemView.findViewById(R.id.contact_avatar);
        name = (TextView) itemView.findViewById(R.id.contact_name);
        title = (TextView) itemView.findViewById(R.id.contact_job);
    }

    public void bindContact(Contact contact) {
        contactId = contact.getId();
        avatar.setImageDrawable(context.getResources().getDrawable(R.drawable.default_avatar));
        LoadImageAsyncTask loadImage = new LoadImageAsyncTask(avatar);
        loadImage.execute(contact.getAvatarUrl());
        name.setText(contact.getName());
        title.setText(contact.getJobTitle());
    }

    @Override
    public void onClick(View v) {
        Intent contactActivityIntent = new Intent(context, ContactActivity.class);
        contactActivityIntent.putExtra(ContactActivity.INTENT_EXTRA_CONTACT_ID, contactId);
        context.startActivity(contactActivityIntent);
    }
}

