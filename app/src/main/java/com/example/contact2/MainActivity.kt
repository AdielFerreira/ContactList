package com.example.contact2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlin.math.log

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{
    lateinit var contacts: ArrayList<Contact>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)
        val rvContacts = findViewById<View>(R.id.rvContacts) as RecyclerView
        contacts = Contact.createContactsList(20)
        val adapter = ContactsAdapter(contacts)
        rvContacts.adapter = adapter
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    private fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.add_contact_bt ->{
                val intent = Intent(this,detail_activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.config_bt ->{
                showToast("Configuracoes")
                return true
            }
            else-> super.onOptionsItemSelected(item)
        }
    }
    private fun initDrawer(){
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_contact_bt ->{
                val intent = Intent(this,detail_activity::class.java)
                startActivity(intent)
            }
            R.id.config_bt ->{
                showToast("Configuracoes")
            }
        }
    return true
    }
}
