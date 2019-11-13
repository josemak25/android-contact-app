package com.example.contactsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class AddContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        // set a click listener for going back homepage
        val goToContacts = findViewById<ImageView>(R.id.goToContacts)
        goToContacts.setOnClickListener{ goBackHome() }


//      get all fields from the form
        val firstNameText = findViewById<EditText>(R.id.user_first_name)
        val lastNameText = findViewById<EditText>(R.id.user_last_name)
        val emailText = findViewById<EditText>(R.id.user_email)
        val phoneText = findViewById<EditText>(R.id.user_phone)

//      get all field values from the form
        val submitButton = findViewById<Button>(R.id.submit_contact)
        submitButton.setOnClickListener{
            val firstName = firstNameText.text.toString()
            val lastName = lastNameText.text.toString()
            val email = emailText.text.toString()
            val phone = phoneText.text.toString()

            //
            addNewContact(firstName, lastName, email, phone)
        }

    }


    private fun goBackHome () {
        val intent =  Intent(this, MainActivity::class.java )
        startActivity(intent)
    }

    private fun addNewContact (firstName: String, lastName: String, email: String, phone: String ) {
        val id = UUID.randomUUID().toString()
        val contact = ContactModel(firstName, lastName, email, phone, id)
        println(contact)
    }

}
