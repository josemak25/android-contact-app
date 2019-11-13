package com.example.contactsapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val fullNamesText = itemView.findViewById<TextView>(R.id.contact_name)!!
    val phoneText = itemView.findViewById<TextView>(R.id.contact_no)!!
    val contactImage = itemView.findViewById<ImageView>(R.id.contact_avater)!!
}