package com.laundryapp

import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.laundryapp.service.RoomActivity
import com.laundryapp.service.RoomsActivity

open class BasicActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_sensors -> startActivity(
                Intent(this, RoomsActivity::class.java)
            )
            R.id.menu_reservations -> startActivity(
                Intent(this, ReservationsActivity::class.java)
            )
            R.id.menu_machines -> startActivity(
                Intent(this, MachinesActivity::class.java)
                //Intent(Intent.ACTION_SENDTO, Uri.parse("mailto://robert.petrelvargas@etu.emse.fr"))
            )

        }
        return super.onContextItemSelected(item)
    }
}