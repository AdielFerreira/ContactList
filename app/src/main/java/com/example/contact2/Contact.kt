package com.example.contact2

import android.content.Intent

data class Contact(val name: String, val phone: String, val photo: String, val isOnline: Boolean) {

    companion object {
        private var lastContactId = 0
        fun createContactsList(numContacts: Int) : ArrayList<Contact> {
            val contacts = ArrayList<Contact>()
            for (i in 1..numContacts) {
                contacts.add(Contact("Pessoa " + ++lastContactId, i.toString(),i.toString(),i <= numContacts / 2))
            }
            return contacts
        }
    }
}