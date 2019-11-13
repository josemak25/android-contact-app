package com.example.contactsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ContactAdapter (private val contactList: MutableList<ContactModel>): RecyclerView.Adapter<ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ContactHolder(view)
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val contact = contactList[position]
        val fullNames = "${contact.firstName} ${contact.lastName}"
        holder.fullNamesText.text = fullNames
        holder.phoneText.text = contact.phone
        Picasso.get().load(contact.picture)
                     .placeholder(R.drawable.default_user)
                     .error(R.drawable.default_user)
                     .into(holder.contactImage)
    }
}

