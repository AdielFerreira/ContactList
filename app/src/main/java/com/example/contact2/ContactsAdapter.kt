package com.example.contact2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ContactsAdapter (private val mContacts: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ContactsAdapter.ViewHolder, position: Int) {
        viewHolder.bind(mContacts[position])
        val contact: Contact = mContacts.get(position)
        var textView = viewHolder.nameTextView
        textView.setText(contact.name)
        textView = viewHolder.phoneTextView
        textView.setText(contact.phone)
        val button = viewHolder.messageButton
        button.text = if (contact.isOnline) "Message" else "Offline"
        button.isEnabled = contact.isOnline
    }

    override fun getItemCount(): Int {
        return mContacts.size
    }
    class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.contact_name)
        val phoneTextView = itemView.findViewById<TextView>(R.id.contact_phone)
        val messageButton = itemView.findViewById<Button>(R.id.message_button)

        fun bind(contact: Contact){


        }
    }
}