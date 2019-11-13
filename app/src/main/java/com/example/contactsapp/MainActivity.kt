package com.example.contactsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.activity_main.*

const val DATABASE_URI = "https://next.json-generator.com/api/json/get/4kMizfloD"

class MainActivity : AppCompatActivity() {
    private  val miniContactDB = mutableListOf<ContactModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactAdapter = ContactAdapter(miniContactDB)
        fab.setOnClickListener { addContacts() }

//        // set recycle view manager here
        val contactRecycleView = findViewById<RecyclerView>(R.id.full_contact_list)
            contactRecycleView.adapter = contactAdapter

        // making network request for online contact data
        AndroidNetworking.initialize(this)
        AndroidNetworking.get(DATABASE_URI)
                         .build()
                         .getAsObjectList(ContactModel::class.java, object: ParsedRequestListener<List<ContactModel>> {
            override fun onResponse(response: List<ContactModel>) {
                miniContactDB.addAll(response)
                contactAdapter.notifyDataSetChanged()
            }

            override fun onError(anError: ANError) {
                anError.printStackTrace()
            }
        })
    }

    private fun addContacts () {
        val intent =  Intent(this, AddContact::class.java )
        startActivity(intent)
    }
}
